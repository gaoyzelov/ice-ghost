package com.gy.ice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gy.ice.common.dto.R;
import com.gy.ice.common.constant.StringConstants;
import com.gy.ice.dao.SysUserDao;
import com.gy.ice.po.SysUser;
import com.gy.ice.service.SysUserService;
import com.gy.ice.common.utils.CacheUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gaoye
 * @date 2021/12/27 9:41
 * @desc
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    @Override
    public R<List<SysUser>> queryUserList(long current,long size) {
        Page<SysUser> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        Page<SysUser> pageInfo = sysUserDao.selectPage(page, null);
        return R.success(pageInfo.getRecords());
    }

    @Override
    public R<?> doLogin(String username, String password) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername,username);
        SysUser sysUser = sysUserDao.selectOne(wrapper);
        if (sysUser == null){
            return R.failed("用户不存在！");
        }
        if (StringUtils.equals(password,sysUser.getPassword())){
            CacheUtils.setValue(StringConstants.USER_ID,sysUser.getId());
            CacheUtils.setValue(StringConstants.USERNAME,sysUser.getUsername());
            return R.success();
        }else{
            return R.failed("密码错误！");
        }
    }
}
