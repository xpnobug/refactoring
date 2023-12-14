package com.kdg.refactoring.kdgservice.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kdg.refactoring.kdgservice.travel.entity.GhDayInfo;

/**
 * (GhDayInfo)表数据库访问层
 *
 * @author couei
 * @since 2023-12-08 01:08:57
 */
public interface GhDayInfoMapper extends BaseMapper<GhDayInfo> {

    GhDayInfo getGhDayInfoById(String id);
}
