package com.kdg.refactoring.kdgservice.travel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kdg.refactoring.kdgcommon.baseresult.JsonObjectResult;
import com.kdg.refactoring.kdgservice.travel.entity.GhTrips;
import com.kdg.refactoring.kdgservice.travel.service.GhTripsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用于存储 data 的主要信息(GhTrips)表控制层
 *
 * @author couei
 * @since 2023-12-08 01:09:05
 */
@RestController
@RequestMapping("ghTrips")
public class GhTripsController {

    /**
     * 服务对象
     */
    @Resource
    private GhTripsService ghTripsService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param ghTrips 查询实体
     * @return 所有数据
     */
    @GetMapping
    public JsonObjectResult selectAll(Page<GhTrips> page, GhTrips ghTrips) {
        return JsonObjectResult.success(
            this.ghTripsService.page(page, new QueryWrapper<>(ghTrips)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonObjectResult selectOne(@PathVariable Serializable id) {
        return JsonObjectResult.success(this.ghTripsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param ghTrips 实体对象
     * @return 新增结果
     */
    @PostMapping
    public JsonObjectResult insert(@RequestBody GhTrips ghTrips) {
        return JsonObjectResult.success(this.ghTripsService.save(ghTrips));
    }

    /**
     * 修改数据
     *
     * @param ghTrips 实体对象
     * @return 修改结果
     */
    @PutMapping
    public JsonObjectResult update(@RequestBody GhTrips ghTrips) {
        return JsonObjectResult.success(this.ghTripsService.updateById(ghTrips));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public JsonObjectResult delete(@RequestBody List<Long> idList) {
        return JsonObjectResult.success(this.ghTripsService.removeByIds(idList));
    }
}
