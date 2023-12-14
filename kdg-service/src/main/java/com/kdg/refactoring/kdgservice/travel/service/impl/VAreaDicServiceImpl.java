package com.kdg.refactoring.kdgservice.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kdg.refactoring.kdgservice.travel.entity.MenuItem;
import com.kdg.refactoring.kdgservice.travel.mapper.VAreaDicMapper;
import com.kdg.refactoring.kdgservice.travel.entity.VAreaDic;
import com.kdg.refactoring.kdgservice.travel.service.VAreaDicService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 区域字典表(VAreaDic)表服务实现类
 *
 * @author couei
 * @since 2023-12-03 16:26:21
 */
@Service("vAreaDicService")
public class VAreaDicServiceImpl extends ServiceImpl<VAreaDicMapper, VAreaDic> implements
    VAreaDicService {

    @Override
    public List<MenuItem> cityDicList() {
        // 创建存放城市菜单项的列表
        List<MenuItem> itemList = new ArrayList<>();

        // 创建 MyBatis Plus 查询包装器
        QueryWrapper<VAreaDic> queryWrapper = new QueryWrapper<>();
        // 设置查询条件，查找顶级城市
        queryWrapper.eq("parent", "-1");
        // 执行查询
        List<VAreaDic> list = list(queryWrapper);

        // 遍历顶级城市列表
        for (VAreaDic areaDic : list) {
            // 创建当前城市的菜单项
            MenuItem menuItem = new MenuItem();
            // 设置菜单项的值和标签
            menuItem.setValue(Long.toString(areaDic.getId()));
            menuItem.setLabel(areaDic.getName());

            // 递归调用 dicList 方法，获取并设置当前城市的子级
            List<MenuItem> children = dicList(menuItem.getValue());
            menuItem.setChildren(children);

            // 将当前城市的菜单项添加到列表中
            itemList.add(menuItem);
        }

        // 返回包含所有城市菜单项的列表
        return itemList;
    }

    /**
     * 递归方法，获取指定父级城市的子级
     * @param parentId
     * @return
     */
    public List<MenuItem> dicList(String parentId) {
        // 创建 MyBatis Plus 查询包装器
        QueryWrapper<VAreaDic> queryWrapper = new QueryWrapper<>();
        // 设置查询条件，查找指定父级城市的子级
        queryWrapper.eq("parent", parentId);
        // 执行查询
        List<VAreaDic> childList = list(queryWrapper);

        // 创建存放子级城市菜单项的列表
        List<MenuItem> childrenItemList = new ArrayList<>();

        // 遍历子级城市列表
        for (VAreaDic childAreaDic : childList) {
            // 创建当前子级城市的菜单项
            MenuItem childMenuItem = new MenuItem();
            // 设置菜单项的值和标签
            childMenuItem.setValue(Long.toString(childAreaDic.getId()));
            childMenuItem.setLabel(childAreaDic.getName());

            // 递归调用 dicList 方法，获取并设置当前子级城市的子级
//            List<MenuItem> grandChildren = dicList(childMenuItem.getValue());
//            childMenuItem.setChildren(grandChildren);

            // 将当前子级城市的菜单项添加到子级城市列表中
            childrenItemList.add(childMenuItem);
        }

        // 返回包含所有子级城市菜单项的列表
        return childrenItemList;
    }

}
