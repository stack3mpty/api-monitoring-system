package com.stack3mpty.apimonitorsystem.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 16:49
 */
@Data
public class AlertLog {
    private Long id;
    private Long apiId;
    private String triggeredAt;
    private String message;
    private Boolean notified; // 是否已发送通知
}
