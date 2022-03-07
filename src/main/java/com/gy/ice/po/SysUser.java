package com.gy.ice.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gaoye
 * @date 2021/12/24 17:38
 * @desc 系统用户
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
public class SysUser extends BaseEntity{

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

}
