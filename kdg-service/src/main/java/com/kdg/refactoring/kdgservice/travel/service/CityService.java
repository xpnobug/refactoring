package com.kdg.refactoring.kdgservice.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kdg.refactoring.kdgservice.travel.entity.City;
import java.util.List;

/**
 * 城市信息表(City)表服务接口
 *
 * @author couei
 * @since 2023-11-30 18:06:24
 */
public interface CityService extends IService<City> {

    List<City> selectAll(Page<City> page, City city, String type);

    List<City> listByParentId(String id);

    List<City> listByNearCity(String parentId);

    boolean deleteById(String cityId);
}
