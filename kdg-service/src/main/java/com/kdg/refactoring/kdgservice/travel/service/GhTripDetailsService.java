package com.kdg.refactoring.kdgservice.travel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kdg.refactoring.kdgservice.travel.entity.GhImgesInfo;
import com.kdg.refactoring.kdgservice.travel.entity.GhTripDetails;
import com.kdg.refactoring.kdgservice.travel.entity.TripData;
import com.kdg.refactoring.kdgservice.travel.entity.TripData.Data;
import java.util.List;

/**
 * 用于存储每个元素的详细信息(GhTripDetails)表服务接口
 *
 * @author couei
 * @since 2023-12-08 01:09:04
 */
public interface GhTripDetailsService extends IService<GhTripDetails> {

    List<Data> selectTripList(GhTripDetails ghTripDetails);

    boolean addDetailsInfo(GhImgesInfo ghTripDetails);
    boolean updDetailsInfo(GhImgesInfo ghTripDetails);
}
