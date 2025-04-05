package com.stack3mpty.apimonitorsystem.task;

import com.stack3mpty.apimonitorsystem.dao.mapper.MonitoredApiMapper;
import com.stack3mpty.apimonitorsystem.dao.mapper.MonitoringLogMapper;
import com.stack3mpty.apimonitorsystem.model.MonitoredApi;
import com.stack3mpty.apimonitorsystem.model.MonitoringLog;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/5 10:11
 */
@Slf4j
@Component
public class ApiMonitorTask {

    private static final Logger logger = LoggerFactory.getLogger(ApiMonitorTask.class);

    private final MonitoredApiMapper monitoredApiMapper;

    private final MonitoringLogMapper monitoringLogMapper;

    private final Executor taskExecutor;

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    public ApiMonitorTask(MonitoredApiMapper monitoredApiMapper, MonitoringLogMapper monitoringLogMapper, Executor taskExecutor) {
        this.monitoredApiMapper = monitoredApiMapper;
        this.monitoringLogMapper = monitoringLogMapper;
        this.taskExecutor = taskExecutor;
    }

    @Scheduled(fixedRate = 60000) // 每 60 秒执行一次
    public void monitorApis() {
        List<MonitoredApi> apis = monitoredApiMapper.findAll();
        for (MonitoredApi api : apis) {
            taskExecutor.execute(() -> monitorSingleApi(api));
        }
    }

    private void monitorSingleApi(MonitoredApi api) {
        logger.info("Start monitoring API: " + api.getName());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api.getUrl()))
                .timeout(Duration.ofSeconds(api.getTimeout()))
                .GET()
                .build();

        MonitoringLog log = new MonitoringLog();
        log.setApiId(api.getId());
        log.setCheckedAt(LocalDateTime.now().toString());

        try {
            long start = System.currentTimeMillis();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("API Monitoring: " + api.getName() + " - Status Code: " + response.statusCode() + ", Response Time: " + (System.currentTimeMillis() - start) + "ms");
            long elapsed = System.currentTimeMillis() - start;

            log.setStatusCode(response.statusCode());
            log.setResponseTime((int) elapsed);
            log.setErrorMessage(null); // 正常情况无异常
        } catch (Exception e) {
            log.setStatusCode(0); // 标识异常
            log.setResponseTime(-1); // 失败标记
            log.setErrorMessage(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        monitoringLogMapper.insert(log);
    }
}
