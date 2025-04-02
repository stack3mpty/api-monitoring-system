package com.stack3mpty.apimonitorsystem.service;

import com.stack3mpty.apimonitorsystem.model.MonitoredApi;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 17:31
 */
public interface IMonitoredApiService {
    void addApi(MonitoredApi api);

    List<MonitoredApi> getApisByUserId(Long userId);

    void deleteApi(Long id);
}
