package com.liuqi.auth.controller;

import com.alibaba.fastjson2.JSON;
import com.liuqi.common.core.utils.ServletUtils;
import com.liuqi.common.core.utils.ip.IpUtils;
import com.liuqi.common.core.utils.uuid.IdUtils;
import com.liuqi.common.security.service.TokenService;
import com.liuqi.system.api.domain.SysUser;
import com.liuqi.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
 *@ClassName TestController
 *@Description TODO
 *@Author LiuQi
 *@Date 2023/1/28 10:11
 *@Version 1.0
 */
@RestController
@RequestMapping(value = "/test")
@Slf4j
public class TestController {


    @GetMapping
    public void test() {
        final Map<String, Object> token = createToken();
        log.info("创建 token： {}", JSON.toJSON(token));
    }


    @Autowired
    TokenService tokenService;

    public  Map<String, Object> createToken(){

        final LoginUser loginUser = LoginUser.builder()
                .sysUser(SysUser.builder()
                        .userId(1L)
                        .userName("AD钙奶")
                        .build())
                .build();
        final Map<String, Object> token = tokenService.createToken(loginUser);
        return token;
    }

    /**
     * 获取 uuid
     * @return
     */
    public static String getUUID() {
        return IdUtils.fastUUID();
    }

    /**
     * 获取ip
     * @return
     */
    public static String getIP() {
        return IpUtils.getIpAddr(ServletUtils.getRequest());
    }
}
