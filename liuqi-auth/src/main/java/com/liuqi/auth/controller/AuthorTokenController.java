package com.liuqi.auth.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.liuqi.auth.form.LoginBody;
import com.liuqi.auth.service.SysLoginService;
import com.liuqi.common.core.domain.R;
import com.liuqi.common.security.service.TokenService;
import com.liuqi.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 *@ClassName AuthorTokenController
 *@Description token 控制
 *@Author LiuQi
 *@Date 2023/1/17 09:13
 *@Version 1.0
 */
@RestController
@Slf4j
@CrossOrigin
public class AuthorTokenController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysLoginService sysLoginService;

    @PostMapping(value = "/login")
    public R<?> login(@RequestBody LoginBody loginBody)
    {
        log.info("AuthorToken 登录参数 {}", JSON.toJSON(loginBody));
        // 登录用户信息
        LoginUser loginUser = sysLoginService.login(loginBody.getUsername(), loginBody.getPassword());
        //TODO 获取登录token
        return R.ok(loginUser);
    }
}
