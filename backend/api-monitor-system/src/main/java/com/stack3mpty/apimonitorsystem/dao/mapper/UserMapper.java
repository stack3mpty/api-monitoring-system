package com.stack3mpty.apimonitorsystem.dao.mapper;

import com.stack3mpty.apimonitorsystem.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 16:50
 */
@Mapper
public interface UserMapper {

    int insert(User user);

    User findById(@Param("id") Long id);

    User findByUsername(@Param("username") String username);

    List<User> findAll();
}
