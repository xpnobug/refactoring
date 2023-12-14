package com.kdg.refactoring.kdgservice.travel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于存储 data 的主要信息(GhTrips)表实体类
 *
 * @author couei
 * @since 2023-12-08 01:10:58
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GhTrips {

    /**
     * 主键
     */
    @TableId
    private String tripId;
    /**
     * 关联到用户的唯一标识符
     */

    private Integer userId;
    /**
     * 行程创建时间
     */

    private Date createdAt;

}
