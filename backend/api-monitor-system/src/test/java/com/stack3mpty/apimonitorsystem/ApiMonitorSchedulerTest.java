package com.stack3mpty.apimonitorsystem;

import com.stack3mpty.apimonitorsystem.dao.mapper.MonitoredApiMapper;
import com.stack3mpty.apimonitorsystem.dao.mapper.MonitoringLogMapper;
import com.stack3mpty.apimonitorsystem.model.MonitoredApi;
import com.stack3mpty.apimonitorsystem.task.ApiMonitorTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/5 11:13
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApiMonitorSchedulerTest {

    @InjectMocks
    private ApiMonitorTask scheduler;

    @Mock
    private MonitoredApiMapper monitoredApiMapper;

    @Mock
    private MonitoringLogMapper monitoringLogMapper;

    @Spy
    private Executor taskExecutor;

    @Test
    void testMonitorApisExecutesTasks() {
        // 模拟返回的 API 列表
        MonitoredApi api1 = new MonitoredApi();
        api1.setId(1L);
        api1.setName("Google");

        List<MonitoredApi> mockApis = Collections.singletonList(api1);
        Mockito.when(monitoredApiMapper.findAll()).thenReturn(mockApis);

        // 用 spy 模拟线程池执行
        ReflectionTestUtils.setField(scheduler, "monitoredApiMapper", monitoredApiMapper);
        ReflectionTestUtils.setField(scheduler, "monitoringLogMapper", monitoringLogMapper);
        ReflectionTestUtils.setField(scheduler, "taskExecutor", taskExecutor);

        // 执行监控方法
        scheduler.monitorApis();

        // 验证线程池是否被调用了
        Mockito.verify(taskExecutor, Mockito.times(1)).execute(Mockito.any(Runnable.class));
    }
}

