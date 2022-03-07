package com.gy.ice.service;

import com.gy.ice.common.dto.R;
import com.gy.ice.po.SysUser;

import java.util.List;

/**
 * @author gaoye
 * @date 2021/12/27 9:40
 * @desc
 */
public interface SysUserService {

    R<List<SysUser>> queryUserList(long current,long size);

    R<?> doLogin(String username, String password);
}
