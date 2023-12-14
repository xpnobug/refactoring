package com.kdg.refactoring.kdgservice.travel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kdg.refactoring.kdgservice.travel.entity.MenuItem;
import com.kdg.refactoring.kdgservice.travel.entity.VAreaDic;
import java.util.List;

/**
 * 区域字典表(VAreaDic)表服务接口
 *
 * @author couei
 * @since 2023-12-03 16:26:20
 */
public interface VAreaDicService extends IService<VAreaDic> {
    List<MenuItem> cityDicList();
}
