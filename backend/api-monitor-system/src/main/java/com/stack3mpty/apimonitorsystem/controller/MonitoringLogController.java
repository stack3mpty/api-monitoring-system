package com.stack3mpty.apimonitorsystem.controller;

import com.stack3mpty.apimonitorsystem.model.MonitoringLog;
import com.stack3mpty.apimonitorsystem.model.dto.MonitoringLogDTO;
import com.stack3mpty.apimonitorsystem.service.Impl.MonitoringLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/2 16:20
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/logs")
public class MonitoringLogController {
    private final MonitoringLogService monitoringLogService;

    public MonitoringLogController(MonitoringLogService monitoringLogService) {
        this.monitoringLogService = monitoringLogService;
    }


    @PostMapping("/save")
    public ResponseEntity<Void> saveLog(@RequestBody MonitoringLog log) {
        monitoringLogService.saveLog(log);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/recent/{apiId}")
    public ResponseEntity<List<MonitoringLogDTO>> getRecentLogs(@PathVariable Long apiId,
                                                                @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(monitoringLogService.getRecentLogs(apiId, limit));
    }

    @GetMapping("/range/{apiId}")
    public ResponseEntity<List<MonitoringLog>> getLogsByDateRange(@PathVariable Long apiId,
                                                                  @RequestParam  String startDate,
                                                                  @RequestParam  String endDate) {
        return ResponseEntity.ok(monitoringLogService.getLogsByDateRange(apiId, startDate, endDate));
    }
}
