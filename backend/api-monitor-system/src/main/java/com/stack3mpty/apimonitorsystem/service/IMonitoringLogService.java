package com.stack3mpty.apimonitorsystem.service;

import com.stack3mpty.apimonitorsystem.model.MonitoringLog;
import com.stack3mpty.apimonitorsystem.model.dto.MonitoringLogDTO;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/2 16:16
 */
public interface IMonitoringLogService {

    void saveLog(MonitoringLog log);

    List<MonitoringLogDTO> getRecentLogs(Long apiId, int limit);

    List<MonitoringLog> getLogsByDateRange(Long apiId, String startDate, String endDate);
}
