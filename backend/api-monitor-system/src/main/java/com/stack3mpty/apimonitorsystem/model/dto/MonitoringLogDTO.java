package com.stack3mpty.apimonitorsystem.model.dto;

import lombok.Data;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/2 17:25
 */
@Data
public class MonitoringLogDTO {
    private Long id;
    private Long apiId;
    private String apiName;
    private String apiUrl;
    private Integer statusCode;
    private Integer responseTime;
    private String checkedAt;
}

