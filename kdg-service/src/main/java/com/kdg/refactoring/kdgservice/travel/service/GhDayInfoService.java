package com.kdg.refactoring.kdgservice.travel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kdg.refactoring.kdgservice.travel.entity.GhDayInfo;

/**
 * (GhDayInfo)表服务接口
 *
 * @author couei
 * @since 2023-12-08 01:08:57
 */
public interface GhDayInfoService extends IService<GhDayInfo> {

    /**
     * selectById 方法
     * @param id
     * @return
     */
    GhDayInfo getGhDayInfoById(String id);
}
