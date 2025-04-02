package com.stack3mpty.apimonitorsystem;

import com.stack3mpty.apimonitorsystem.dao.mapper.UserMapper;
import com.stack3mpty.apimonitorsystem.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 16:59
 */
@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testFindById() {
        User user = userMapper.findById(1L);
//        System.out.println(user);
//        System.out.println(user.getUsername());
    }
}
