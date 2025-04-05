package com.stack3mpty.apimonitorsystem.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 16:47
 */
@Data
public class MonitoredApi {

    private Long id;
    private Long userId;
    private String name;
    private String url;
    private Integer checkInterval; // 监控间隔（秒）
    private Integer timeout; // 超时时间（秒）
    private String createdAt;
}
