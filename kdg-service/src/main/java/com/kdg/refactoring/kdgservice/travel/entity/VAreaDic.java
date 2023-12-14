package com.kdg.refactoring.kdgservice.travel.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 区域字典表(VAreaDic)表实体类
 *
 * @author couei
 * @since 2023-12-03 16:26:20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VAreaDic {

    /**
     * 主键
     */

    private Long id;
    /**
     * 区域名称
     */

    private String name;
    /**
     * 区域编号
     */

    private String areano;
    /**
     * 父级区域
     */

    private Long parent;
    /**
     * 0:未激活 1:已激活
     */

    private Integer isactivated;
    /**
     * 是否是商圈(0:不是 1:是)
     */

    private Integer istradingarea;
    /**
     * (0:不是 1：是)
     */

    private Integer ishot;
    /**
     * 区域级别(0:国家级 1:省级 2:市级 3:县/区)
     */

    private Integer level;
    /**
     * 1:国内 2：国外
     */

    private Integer ischina;

    private String pinyin;

    private Date creationdate;

    private Long createdby;

    private Date modifydate;

    private Long modifiedby;

}
