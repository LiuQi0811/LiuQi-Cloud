package com.liuqi.auth.controller;

import com.liuqi.common.core.utils.ServletUtils;
import com.liuqi.common.core.utils.ip.IpUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@ClassName TestController
 *@Description TODO
 *@Author LiuQi
 *@Date 2023/1/28 10:11
 *@Version 1.0
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {




    @GetMapping
    public void test(){
        IpUtils.getIpAddr(ServletUtils.getRequest());
    }
}
