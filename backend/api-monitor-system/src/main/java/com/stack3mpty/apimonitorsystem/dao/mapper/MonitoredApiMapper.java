package com.stack3mpty.apimonitorsystem.dao.mapper;

import com.stack3mpty.apimonitorsystem.model.MonitoredApi;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 16:53
 */
@Mapper
public interface MonitoredApiMapper {

    int insert(MonitoredApi api);

    List<MonitoredApi> findByUserId(@Param("userId") Long userId);

    int deleteById(@Param("id") Long id);

    List<MonitoredApi> findAll();
}
