package com.gy.ice.controller;

import com.gy.ice.common.constant.StringConstants;
import com.gy.ice.common.dto.R;
import com.gy.ice.common.utils.CacheUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoye
 * @date 2021/12/31 17:53
 * @desc
 */
@RestController
public class UserController {

    @GetMapping("getLoginUser")
    public R<String> getLoginUser(){
        String value = CacheUtils.getValue(StringConstants.USERNAME);
        return R.success(value);
    }

}
