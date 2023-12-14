package com.kdg.refactoring.kdgservice.travel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (GhDayInfo)表实体类
 *
 * @author couei
 * @since 2023-12-08 01:10:57
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GhDayInfo {

    @TableId
    private String dayId;

    private String dayTitle;

    private String dayDesc;

    private Date dayStartTime;

    private Date dayEndTime;

    private String dayBudget;

    private String dayState;

}
