package com.liuqi.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@ClassName AuthorTokenController
 *@Description token 控制
 *@Author LiuQi
 *@Date 2023/1/17 09:13
 *@Version 1.0
 */
@RestController
public class AuthorTokenController {
    @PostMapping(value = "/login")
    public Object login() {
        return null;
    }
}
