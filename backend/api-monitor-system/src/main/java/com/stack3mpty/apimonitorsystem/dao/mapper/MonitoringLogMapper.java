package com.stack3mpty.apimonitorsystem.dao.mapper;

import com.stack3mpty.apimonitorsystem.model.MonitoringLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 16:54
 */
@Mapper
public interface MonitoringLogMapper {

    int insert(MonitoringLog log);

    List<MonitoringLog> findRecentLogs(@Param("apiId") Long apiId, @Param("limit") int limit);
}
