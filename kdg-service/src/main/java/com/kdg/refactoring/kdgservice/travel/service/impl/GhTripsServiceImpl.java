package com.kdg.refactoring.kdgservice.travel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kdg.refactoring.kdgservice.travel.mapper.GhTripsMapper;
import com.kdg.refactoring.kdgservice.travel.entity.GhTrips;
import com.kdg.refactoring.kdgservice.travel.service.GhTripsService;
import org.springframework.stereotype.Service;

/**
 * 用于存储 data 的主要信息(GhTrips)表服务实现类
 *
 * @author couei
 * @since 2023-12-08 01:09:05
 */
@Service("ghTripsService")
public class GhTripsServiceImpl extends ServiceImpl<GhTripsMapper, GhTrips> implements
    GhTripsService {

}
