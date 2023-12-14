package com.kdg.refactoring.kdgservice.travel.controller;

import com.kdg.refactoring.kdgcommon.baseresult.JsonObjectResult;
import com.kdg.refactoring.kdgservice.travel.entity.VAreaDic;
import com.kdg.refactoring.kdgservice.travel.service.VAreaDicService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 区域字典表(VAreaDic)表控制层
 *
 * @author couei
 * @since 2023-12-03 16:26:21
 */
@RestController
@RequestMapping("vAreaDic")
public class VAreaDicController {

    /**
     * 服务对象
     */
    @Resource
    private VAreaDicService vAreaDicService;

    /**
     * 查询所有数据
     *
     * @param cityId
     * @return 所有数据
     */
    @GetMapping("/dicList")
    public JsonObjectResult selectAllList(String cityId) {
        return JsonObjectResult.success(this.vAreaDicService.cityDicList());
    }


    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param vAreaDic 查询实体
     * @return 所有数据
     */
    @GetMapping
    public JsonObjectResult selectAll(Page<VAreaDic> page, VAreaDic vAreaDic) {
        return JsonObjectResult.success(
            this.vAreaDicService.page(page, new QueryWrapper<>(vAreaDic)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonObjectResult selectOne(@PathVariable Serializable id) {
        return JsonObjectResult.success(this.vAreaDicService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param vAreaDic 实体对象
     * @return 新增结果
     */
    @PostMapping
    public JsonObjectResult insert(@RequestBody VAreaDic vAreaDic) {
        return JsonObjectResult.success(this.vAreaDicService.save(vAreaDic));
    }

    /**
     * 修改数据
     *
     * @param vAreaDic 实体对象
     * @return 修改结果
     */
    @PutMapping
    public JsonObjectResult update(@RequestBody VAreaDic vAreaDic) {
        return JsonObjectResult.success(this.vAreaDicService.updateById(vAreaDic));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public JsonObjectResult delete(@RequestBody List<Long> idList) {
        return JsonObjectResult.success(this.vAreaDicService.removeByIds(idList));
    }
}
