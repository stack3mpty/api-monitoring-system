package com.stack3mpty.apimonitorsystem.dao.mapper;

import com.stack3mpty.apimonitorsystem.model.AlertLog;
import com.stack3mpty.apimonitorsystem.model.dto.AlertLogDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 16:57
 */
@Mapper
public interface AlertLogMapper {

    int insert(AlertLogMapper log);

    List<AlertLog> findRecentLogs(@Param("apiId") Long apiId, @Param("limit") int limit);

    List<AlertLogDTO> findRecentAlerts(@Param("apiId") Long apiId, @Param("limit") int limit);
}
