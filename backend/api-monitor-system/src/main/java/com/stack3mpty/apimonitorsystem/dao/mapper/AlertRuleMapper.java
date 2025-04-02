package com.stack3mpty.apimonitorsystem.dao.mapper;

import com.stack3mpty.apimonitorsystem.model.AlertRule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 16:54
 */
@Mapper
public interface AlertRuleMapper {

    int insert(AlertRule rule);

    List<AlertRule> findByApiId(@Param("apiId") Long apiId);
}
