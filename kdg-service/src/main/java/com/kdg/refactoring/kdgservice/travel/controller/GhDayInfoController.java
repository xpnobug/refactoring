package com.kdg.refactoring.kdgservice.travel.controller;

import com.kdg.refactoring.kdgcommon.baseresult.JsonObjectResult;
import com.kdg.refactoring.kdgservice.travel.entity.GhDayInfo;
import com.kdg.refactoring.kdgservice.travel.service.GhDayInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (GhDayInfo)表控制层
 *
 * @author couei
 * @since 2023-12-08 01:18:56
 */
@RestController
@RequestMapping("/ghDayInfo")
public class GhDayInfoController {

    /**
     * 服务对象
     */
    @Resource
    private GhDayInfoService ghDayInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page      分页对象
     * @param ghDayInfo 查询实体
     * @return 所有数据
     */
    @GetMapping("/selectAll")
    public JsonObjectResult selectAll(Page<GhDayInfo> page, GhDayInfo ghDayInfo) {
        return JsonObjectResult.success(
            this.ghDayInfoService.page(page, new QueryWrapper<>(ghDayInfo)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/detail")
    public JsonObjectResult selectOne(String id) {
        return JsonObjectResult.success(this.ghDayInfoService.getGhDayInfoById(id));
    }

    /**
     * 新增数据
     *
     * @param ghDayInfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public JsonObjectResult insert(@RequestBody GhDayInfo ghDayInfo) {
        return JsonObjectResult.success(this.ghDayInfoService.save(ghDayInfo));
    }

    /**
     * 修改数据
     *
     * @param ghDayInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public JsonObjectResult update(@RequestBody GhDayInfo ghDayInfo) {
        return JsonObjectResult.success(this.ghDayInfoService.updateById(ghDayInfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public JsonObjectResult delete(@RequestBody List<Long> idList) {
        return JsonObjectResult.success(this.ghDayInfoService.removeByIds(idList));
    }
}
