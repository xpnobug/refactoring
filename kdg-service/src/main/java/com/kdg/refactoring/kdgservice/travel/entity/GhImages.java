package com.kdg.refactoring.kdgservice.travel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于存储所有图片的表(GhImages)表实体类
 *
 * @author couei
 * @since 2023-12-08 01:10:57
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GhImages {

    /**
     * 主键，图片的唯一标识符
     */
    @TableId
    private String imageId;
    /**
     * 外键，关联到 Trips 表的 trip_id
     */

    private String tripId;
    /**
     * 外键，关联到 TripDetails 表的 detail_id
     */

    private String detailId;
    /**
     * 图片的 URL 地址
     */

    private String url;

}
