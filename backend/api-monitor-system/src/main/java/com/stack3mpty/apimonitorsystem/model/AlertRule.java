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
public class AlertRule {
    private Long id;
    private Long apiId;
    private String ruleType; // TIMEOUT 或 STATUS_CODE
    private Integer threshold; // 触发告警的阈值
    private Boolean notifyEmail; // 是否邮件通知
    private Boolean notifyWebhook; // 是否 Webhook 通知
    private String webhookUrl;
    private String createdAt;
}
