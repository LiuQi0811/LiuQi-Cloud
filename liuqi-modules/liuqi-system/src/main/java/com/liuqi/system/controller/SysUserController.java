package com.liuqi.system.controller;

import com.liuqi.common.core.domain.R;
import com.liuqi.system.api.domain.SysUser;
import com.liuqi.system.api.model.LoginUser;
import com.liuqi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        // 根据名称获取用户信息
        SysUser sysUser = userService.selectUserByUserName(username);
        // 根据用户信息 获取 用户信息列表
        List<SysUser> sysUsers = userService.selectUserList(sysUser);
        LoginUser loginUser = LoginUser.builder()
                .sysUser(sysUser)
                .build();
        return R.ok(loginUser);
    }


}
