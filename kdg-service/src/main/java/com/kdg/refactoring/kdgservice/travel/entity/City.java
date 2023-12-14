package com.kdg.refactoring.kdgservice.travel.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 城市信息表(City)表实体类
 *
 * @author couei
 * @since 2023-11-30 18:06:20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    /**
     * 城市ID，自增
     */

    private String id;
    /**
     * 城市名称，非空
     */

    private String cityName;
    /**
     * 城市编码
     */

    private String cityCode;
    /**
     * 所属国家，非空
     */

    private String country;
    /**
     * 城市图片
     */

    private String cityImg;
    /**
     * 上级id
     */

    private String parentId;
    /**
     * 上级城市名称
     */

    private String parentName;
    /**
     * 类型：省级城市，地级城市 ，县级城市 ，直辖市
     */

    private String cityType;

    private String parentDicId;
    /**
     * 参观时间
     */

    private String visitTime;
    /**
     * 描述
     */

    private String description;
    /**
     * 状态（0：正常，1：异常）
     */

    private Integer state;
    /**
     * 门票
     */

    private BigDecimal admissionFee;
    /**
     * 地理位置
     */

    private String position;
    /**
     * 创建人
     */

    private String createUser;
    /**
     * 创建时间
     */

    private Date createTime;
    /**
     * 修改人
     */

    private String updateUser;
    /**
     * 修改时间
     */

    private Date updateTime;

}
