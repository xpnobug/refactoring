package com.kdg.refactoring.kdgservice.travel.controller;

import com.kdg.refactoring.kdgcommon.baseresult.JsonObjectResult;
import com.kdg.refactoring.kdgservice.travel.entity.City;
import com.kdg.refactoring.kdgservice.travel.service.CityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 城市信息表(City)表控制层
 *
 * @author couei
 * @since 2023-11-30 18:06:28
 */
@RestController
@RequestMapping("/voyageguide/city")
public class CityController {

    /**
     * 服务对象
     */
    @Resource
    private CityService cityService;

    /**
     * 通过父级查询数据
     *
     * @param parentId
     * @return 单条数据
     */
    @GetMapping("/listByParentId")
    public JsonObjectResult listByParentId(String parentId) {
        return JsonObjectResult.success(this.cityService.listByParentId(parentId));
    }

    /**
     * 查询数据
     *
     * @param parentId
     * @return 单条数据
     */
    @GetMapping("/listByNearCity")
    public JsonObjectResult listByNearCity(String parentId) {
        return JsonObjectResult.success(this.cityService.listByNearCity(parentId));
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param city 查询实体
     * @return 所有数据
     */
    @GetMapping("/selectAll")
    public JsonObjectResult selectAll(Page<City> page, City city,String type) {
        return JsonObjectResult.success(this.cityService.selectAll(page,city,type));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonObjectResult selectOne(@PathVariable Serializable id) {
        return JsonObjectResult.success(this.cityService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param city 实体对象
     * @return 新增结果
     */
    @PostMapping("/addCity")
    public JsonObjectResult insert(@RequestBody City city) {
        return JsonObjectResult.success(this.cityService.save(city));
    }

    /**
     * 修改数据
     *
     * @param city 实体对象
     * @return 修改结果
     */
    @PostMapping("/updateCity")
    public JsonObjectResult update(@RequestBody City city) {
        return JsonObjectResult.success(this.cityService.updateById(city));
    }

    /**
     * 删除数据
     *
     * @param cityId 主键结合
     * @return 删除结果
     */
    @GetMapping("/delCity")
    public JsonObjectResult delete(String cityId) {
        System.out.println("进入");
        return JsonObjectResult.success(this.cityService.deleteById(cityId));
    }
}
