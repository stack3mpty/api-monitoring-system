package com.stack3mpty.apimonitorsystem.model.dto;

import lombok.Data;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/11 15:21
 */
@Data
public class AlertLogDTO {
    private Long id;
    private Long apiId;
    private String apiName;
    private String apiUrl;
    private String message;
    private String triggeredAt;
}

