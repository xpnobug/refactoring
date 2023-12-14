package com.kdg.refactoring.kdgservice.travel.controller;

import com.kdg.refactoring.kdgcommon.baseresult.JsonObjectResult;
import com.kdg.refactoring.kdgservice.travel.entity.GhImages;
import com.kdg.refactoring.kdgservice.travel.service.GhImagesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用于存储所有图片的表(GhImages)表控制层
 *
 * @author couei
 * @since 2023-12-08 01:09:03
 */
@RestController
@RequestMapping("ghImages")
public class GhImagesController {

    /**
     * 服务对象
     */
    @Resource
    private GhImagesService ghImagesService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param ghImages 查询实体
     * @return 所有数据
     */
    @GetMapping
    public JsonObjectResult selectAll(Page<GhImages> page, GhImages ghImages) {
        return JsonObjectResult.success(
            this.ghImagesService.page(page, new QueryWrapper<>(ghImages)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonObjectResult selectOne(@PathVariable Serializable id) {
        return JsonObjectResult.success(this.ghImagesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param ghImages 实体对象
     * @return 新增结果
     */
    @PostMapping
    public JsonObjectResult insert(@RequestBody GhImages ghImages) {
        return JsonObjectResult.success(this.ghImagesService.save(ghImages));
    }

    /**
     * 修改数据
     *
     * @param ghImages 实体对象
     * @return 修改结果
     */
    @PutMapping
    public JsonObjectResult update(@RequestBody GhImages ghImages) {
        return JsonObjectResult.success(this.ghImagesService.updateById(ghImages));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public JsonObjectResult delete(@RequestBody List<Long> idList) {
        return JsonObjectResult.success(this.ghImagesService.removeByIds(idList));
    }
}
