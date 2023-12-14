package com.kdg.refactoring.kdgservice.travel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于存储每个元素的详细信息(GhTripDetails)表实体类
 *
 * @author couei
 * @since 2023-12-08 20:47:26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GhTripDetails {

    /**
     * 主键，行程细节的唯一标识符
     */
    @TableId
    private String detailId;
    /**
     * 外键，关联
     */

    private String dayId;
    /**
     * 标题，景点、车次等
     */

    private String title;
    /**
     * 支出金额
     */

    private BigDecimal money;
    /**
     * 交通方式，火车、汽车等
     */

    private String traffic;
    /**
     * 出发城市
     */

    private String startCity;
    /**
     * 到达城市
     */

    private String endCity;
    /**
     * 开始时间
     */

    private LocalTime startTime;
    /**
     * 结束时间
     */

    private LocalTime endTime;
    /**
     * 描述，上海站乘坐 G222 到达济南站等
     */

    private String description;
    /**
     * 位置，例如北京
     */

    private String position;
    /**
     * 创意类型，例如 "1" 表示交通
     */

    private String creatType;
    /**
     * 天数tab切换
     */

    private String dayTab;

}
