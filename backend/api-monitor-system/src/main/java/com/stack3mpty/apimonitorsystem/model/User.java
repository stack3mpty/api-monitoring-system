package com.stack3mpty.apimonitorsystem.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 16:47
 */
@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String createdAt;
}
