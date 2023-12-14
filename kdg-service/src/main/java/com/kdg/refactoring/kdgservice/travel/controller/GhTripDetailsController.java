package com.kdg.refactoring.kdgservice.travel.controller;

import com.kdg.refactoring.kdgcommon.baseresult.JsonObjectResult;
import com.kdg.refactoring.kdgservice.travel.entity.GhImgesInfo;
import com.kdg.refactoring.kdgservice.travel.entity.GhTripDetails;
import com.kdg.refactoring.kdgservice.travel.service.GhTripDetailsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用于存储每个元素的详细信息(GhTripDetails)表控制层
 *
 * @author couei
 * @since 2023-12-08 01:09:04
 */
@RestController
@RequestMapping("/ghTripDetails")
public class GhTripDetailsController {

    /**
     * 服务对象
     */
    @Resource
    private GhTripDetailsService ghTripDetailsService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param ghTripDetails 查询实体
     * @return 所有数据
     */
    @GetMapping("/selectAll")
    public JsonObjectResult selectAll(Page<GhTripDetails> page, GhTripDetails ghTripDetails) {
        return JsonObjectResult.success(
            this.ghTripDetailsService.selectTripList(ghTripDetails));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonObjectResult selectOne(@PathVariable Serializable id) {
        return JsonObjectResult.success(this.ghTripDetailsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param ghTripDetails 实体对象
     * @return 新增结果
     */
    @PostMapping("/addDetailsInfo")
    public JsonObjectResult insert(@RequestBody GhImgesInfo ghTripDetails) {
        return JsonObjectResult.success(this.ghTripDetailsService.addDetailsInfo(ghTripDetails));
    }

    /**
     * 修改数据
     *
     * @param ghTripDetails 实体对象
     * @return 修改结果
     */
    @PutMapping
    public JsonObjectResult update(@RequestBody GhTripDetails ghTripDetails) {
        return JsonObjectResult.success(this.ghTripDetailsService.updateById(ghTripDetails));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public JsonObjectResult delete(@RequestBody List<Long> idList) {
        return JsonObjectResult.success(this.ghTripDetailsService.removeByIds(idList));
    }
}
