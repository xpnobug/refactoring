package com.kdg.refactoring.kdgservice.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kdg.refactoring.kdgservice.travel.mapper.CityMapper;
import com.kdg.refactoring.kdgservice.travel.entity.City;
import com.kdg.refactoring.kdgservice.travel.service.CityService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 城市信息表(City)表服务实现类
 *
 * @author couei
 * @since 2023-11-30 18:06:26
 */
@Service("cityService")
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

    @Override
    public List<City> selectAll(Page<City> page, City city, String type) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        if ("cityList".equals(type)){
            queryWrapper.isNull("parent_id");
        }else {
            queryWrapper.isNotNull("parent_id");
        }
        return list(queryWrapper);
    }

    @Override
    public List<City> listByParentId(String id) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        // 设置查询条件，查找指定父级城市的子级
        queryWrapper.eq("parent_dic_id", id);
        // 执行查询
        return list(queryWrapper);
    }

    @Override
    public List<City> listByNearCity(String parentId) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        // 设置查询条件，查找指定父级城市的子级
        queryWrapper.eq("parent_id", parentId);
        return list(queryWrapper);
    }

    @Override
    public boolean deleteById(String cityId) {
        return super.removeById(cityId);
    }
}
