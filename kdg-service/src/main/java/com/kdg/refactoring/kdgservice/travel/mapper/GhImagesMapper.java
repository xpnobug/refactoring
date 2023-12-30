package com.kdg.refactoring.kdgservice.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kdg.refactoring.kdgservice.travel.entity.GhImages;
import java.util.List;

/**
 * 用于存储所有图片的表(GhImages)表数据库访问层
 *
 * @author couei
 * @since 2023-12-08 01:09:00
 */
public interface GhImagesMapper extends BaseMapper<GhImages> {
    List<GhImages> getImgList(String id);
}
