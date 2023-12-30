package com.kdg.refactoring.kdgservice.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kdg.refactoring.kdgservice.travel.mapper.GhImagesMapper;
import com.kdg.refactoring.kdgservice.travel.entity.GhImages;
import com.kdg.refactoring.kdgservice.travel.service.GhImagesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用于存储所有图片的表(GhImages)表服务实现类
 *
 * @author couei
 * @since 2023-12-08 01:09:02
 */
@Service("ghImagesService")
public class GhImagesServiceImpl extends ServiceImpl<GhImagesMapper, GhImages> implements
    GhImagesService {

    @Autowired
    private GhImagesMapper ghImagesMapper;
    @Override
    public List<GhImages> getImgList(String id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("detail_id",id);
        List<GhImages> imagesList = ghImagesMapper.getImgList(id);
        return imagesList;
    }
}
