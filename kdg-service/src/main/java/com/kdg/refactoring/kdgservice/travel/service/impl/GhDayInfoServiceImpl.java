package com.kdg.refactoring.kdgservice.travel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kdg.refactoring.kdgservice.travel.entity.GhDayInfo;
import com.kdg.refactoring.kdgservice.travel.mapper.GhDayInfoMapper;
import com.kdg.refactoring.kdgservice.travel.service.GhDayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (GhDayInfo)表服务实现类
 *
 * @author couei
 * @since 2023-12-08 01:08:58
 */
@Service("ghDayInfoService")
public class GhDayInfoServiceImpl extends ServiceImpl<GhDayInfoMapper, GhDayInfo> implements
    GhDayInfoService {

    @Autowired
    private GhDayInfoMapper ghDayInfoMapper;

    @Override
    public GhDayInfo getGhDayInfoById(String id) {
        return ghDayInfoMapper.getGhDayInfoById(id);
    }
}
