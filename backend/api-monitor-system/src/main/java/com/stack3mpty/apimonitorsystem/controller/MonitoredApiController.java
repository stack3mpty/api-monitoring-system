package com.stack3mpty.apimonitorsystem.controller;

import com.stack3mpty.apimonitorsystem.model.MonitoredApi;
import com.stack3mpty.apimonitorsystem.service.IMonitoredApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 17:30
 */

@RestController
@RequestMapping("/api/monitor")
public class MonitoredApiController {

    private final IMonitoredApiService monitoredApiService;

    public MonitoredApiController(IMonitoredApiService monitoredApiService) {
        this.monitoredApiService = monitoredApiService;
    }

    // 添加 API 监控
    @PostMapping("/add")
    public String addApi(@RequestBody MonitoredApi api) {
        monitoredApiService.addApi(api);
        return "API 监控已添加！";
    }

    // 查询用户的 API 监控列表
    @GetMapping("/list/{userId}")
    public List<MonitoredApi> getApis(@PathVariable Long userId) {
        return monitoredApiService.getApisByUserId(userId);
    }

    // 删除 API 监控
    @DeleteMapping("/delete/{id}")
    public String deleteApi(@PathVariable Long id) {
        monitoredApiService.deleteApi(id);
        return "API 监控已删除！";
    }
}
