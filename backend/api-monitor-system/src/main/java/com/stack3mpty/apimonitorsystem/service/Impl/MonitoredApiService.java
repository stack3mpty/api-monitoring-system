package com.stack3mpty.apimonitorsystem.service.Impl;

import com.stack3mpty.apimonitorsystem.dao.mapper.MonitoredApiMapper;
import com.stack3mpty.apimonitorsystem.model.MonitoredApi;
import com.stack3mpty.apimonitorsystem.service.IMonitoredApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 17:32
 */
@Service
public class MonitoredApiService implements IMonitoredApiService {


    private final MonitoredApiMapper monitoredApiMapper;

    public MonitoredApiService(MonitoredApiMapper monitoredApiMapper) {
        this.monitoredApiMapper = monitoredApiMapper;
    }

    public void addApi(MonitoredApi api) {
        monitoredApiMapper.insert(api);
    }

    public List<MonitoredApi> getApisByUserId(Long userId) {
        return monitoredApiMapper.findByUserId(userId);
    }

    public void deleteApi(Long id) {
        monitoredApiMapper.deleteById(id);
    }
}
