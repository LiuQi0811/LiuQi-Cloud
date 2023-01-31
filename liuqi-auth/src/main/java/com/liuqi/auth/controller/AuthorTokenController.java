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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/*
 *@ClassName AuthorTokenController
 *@Description token 控制
 *@Author LiuQi
 *@Date 2023/1/17 09:13
 *@Version 1.0
 */
@RestController
@Slf4j
public class AuthorTokenController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysLoginService sysLoginService;

    /**
     * 用户登录
     * @param loginBody
     * @return
     */
    @PostMapping(value = "/login")
    public R<?> login(@RequestBody LoginBody loginBody) {
        log.info("AuthorToken 登录参数 {}", JSON.toJSON(loginBody));
        // 登录用户信息
        LoginUser loginUser = sysLoginService.login(loginBody.getUsername(), loginBody.getPassword());
        //获取登录token
        final Map<String, Object> token = tokenService.createToken(loginUser);
        return R.ok(token);
    }

    /**
     * 用户退出
     * @param request
     * @return
     */
    @DeleteMapping(value = "/logout")
    public R<?> logout(HttpServletRequest request){
        log.info("用户退出 请求信息： {}",request);
        return R.ok();
    }
}
