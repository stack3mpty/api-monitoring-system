package com.stack3mpty.apimonitorsystem.controller;

import com.stack3mpty.apimonitorsystem.dao.mapper.UserMapper;
import com.stack3mpty.apimonitorsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/7 21:06
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserMapper userMapper;

    public AuthController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");

        User user = userMapper.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // 后期可以用 JWT 替代
            return ResponseEntity.ok(Map.of("message", "登录成功", "userId", user.getId()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "用户名或密码错误"));
        }
    }
}

