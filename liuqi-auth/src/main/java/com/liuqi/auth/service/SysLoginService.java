package com.liuqi.auth.service;

import com.liuqi.common.core.domain.R;
import com.liuqi.system.api.client.RemoteUserFeignClient;
import com.liuqi.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *@ClassName SysLoginService
 *@Description 登录校验方法
 *@Author LiuQi
 *@Date 2023/1/17 10:36
 *@Version 1.0
 */

@Component
@Slf4j
public class SysLoginService {
    @Autowired
    private RemoteUserFeignClient userFeignClient;
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    public LoginUser login(String username, String password) {
        // 参数校验 用户名 密码
        if (StringUtils.isAnyBlank(username, password)) {  // 用户名或密码为空 错误
            log.info("用户/密码必须填写");
            throw new RuntimeException("用户/密码必须填写");
        }
        if (username.length() < 2 || username.length() > 20) { // 用户名如果不在指定范围内 错误
            log.info("用户名不在指定范围");
            throw new RuntimeException("用户名不在指定范围");
        }
        if (password.length() < 5 || password.length() > 20) {// 密码如果不在指定范围内 错误
            log.info("用户密码不在指定范围");
            throw new RuntimeException("用户密码不在指定范围");
        }
        // 查询用户信息
        R<LoginUser> userInfo = userFeignClient.getUserInfo(username);
        log.info("查询用户信息  {} ",userInfo);

        return null;
    }
}
