package com.stack3mpty.apimonitorsystem.controller;

import com.stack3mpty.apimonitorsystem.dao.mapper.AlertLogMapper;
import com.stack3mpty.apimonitorsystem.model.dto.AlertLogDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/11 15:19
 */
@RestController
@RequestMapping("/api/alerts")
public class AlertLogController {

    private final AlertLogMapper alertLogMapper;

    public AlertLogController(AlertLogMapper alertLogMapper) {
        this.alertLogMapper = alertLogMapper;
    }

    @GetMapping("/recent/{apiId}")
    public List<AlertLogDTO> getRecentAlerts(@PathVariable Long apiId, @PathVariable int limit) {
        return alertLogMapper.findRecentAlerts(apiId, limit);
    }
}
