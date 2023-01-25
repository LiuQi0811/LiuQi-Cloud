package com.liuqi.system.controller;

import com.liuqi.common.core.domain.R;
import com.liuqi.system.api.model.LoginUser;
import com.liuqi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/*
 *@ClassName SysUserController
 *@Description 用户信息接口相关
 *@Author LiuQi
 *@Date 2023/1/19 21:06
 *@Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class SysUserController
{
    @Autowired
    private ISysUserService userService;

    /**
     * 获取当前用户信息
     * @param username 用户名
     * @return
     */
    @GetMapping(value = "/info/{username}")
    public R<LoginUser> info(@PathVariable(value = "username")String username){
        return userService.info(username);
    }


}
