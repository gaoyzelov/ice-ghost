package com.gy.ice.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author gaoye
 * @date 2021/12/24 17:35
 * @desc 基类
 */
@Data
public class BaseEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private long id;

    @TableField(value = "create_by")
    private String createBy;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_by")
    private String updateBy;

    @TableField(value = "update_time")
    private Date updateTime;
}
