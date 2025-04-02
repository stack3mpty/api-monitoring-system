package com.stack3mpty.apimonitorsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stack3mpty.apimonitorsystem.dao.mapper")
public class ApiMonitorSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiMonitorSystemApplication.class, args);
    }

}
