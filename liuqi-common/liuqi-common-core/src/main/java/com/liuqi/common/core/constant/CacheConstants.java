package com.liuqi.common.core.constant;

/*
 *@ClassName CacheConstants
 *@Description 缓存常量信息
 *@Author LiuQi
 *@Date 2023/1/29 09:24
 *@Version 1.0
 */
public class CacheConstants
{
    /**
     * 缓存有效期，默认720（分钟）
     */
    public final static long EXPIRATION = 720;

    /**
     * 权限缓存前缀
     */
    public final static String LOGIN_TOKEN_KEY = "login_tokens:";
}
