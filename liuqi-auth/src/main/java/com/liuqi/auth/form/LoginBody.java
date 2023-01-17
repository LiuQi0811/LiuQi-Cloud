package com.liuqi.auth.form;

import lombok.Data;

/*
 *@ClassName LoginBody
 *@Description 用户登录对象
 *@Author LiuQi
 *@Date 2023/1/17 10:37
 *@Version 1.0
 */
@Data
public class LoginBody {
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;
}
