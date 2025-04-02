package com.stack3mpty.apimonitorsystem.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 16:48
 */
@Data
public class MonitoringLog {
    private Long id;
    private Long apiId;
    private Integer statusCode; // API 状态码
    private Integer responseTime; // 响应时间（毫秒）
    private String checkedAt; // 监测时间
}
