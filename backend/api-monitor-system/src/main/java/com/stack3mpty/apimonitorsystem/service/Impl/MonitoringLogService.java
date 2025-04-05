package com.stack3mpty.apimonitorsystem.service.Impl;

import com.stack3mpty.apimonitorsystem.dao.mapper.MonitoringLogMapper;
import com.stack3mpty.apimonitorsystem.model.MonitoringLog;
import com.stack3mpty.apimonitorsystem.model.dto.MonitoringLogDTO;
import com.stack3mpty.apimonitorsystem.service.IMonitoringLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/2 16:15
 */
@Service
public class MonitoringLogService implements IMonitoringLogService {

    private final MonitoringLogMapper monitoringLogMapper;

    public MonitoringLogService(MonitoringLogMapper monitoringLogMapper) {
        this.monitoringLogMapper = monitoringLogMapper;
    }

    public void saveLog(MonitoringLog log) {
        monitoringLogMapper.insert(log);
    }

    public List<MonitoringLogDTO> getRecentLogs(Long apiId, int limit) {
        return monitoringLogMapper.findRecentLogs(apiId, limit);
    }

    public List<MonitoringLog> getLogsByDateRange(Long apiId, String startDate, String endDate) {
        return monitoringLogMapper.findLogsByDateRange(apiId, startDate, endDate);
    }
}
