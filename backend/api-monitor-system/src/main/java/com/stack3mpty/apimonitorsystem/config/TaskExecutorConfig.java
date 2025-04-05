package com.stack3mpty.apimonitorsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/5 10:21
 */
@Configuration
public class TaskExecutorConfig {

    @Bean
    public Executor taskExecutor() {
        return Executors.newFixedThreadPool(10);
    }
}

