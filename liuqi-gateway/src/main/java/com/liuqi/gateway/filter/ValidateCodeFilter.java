package com.liuqi.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

/*
 *@ClassName ValidateCodeFilter
 *@Description 验证码过滤器
 *@Author LiuQi
 *@Date 2023/1/30 20:27
 *@Version 1.0
 */
public class ValidateCodeFilter extends AbstractGatewayFilterFactory<Object> {
    private final static String[] VALIDATE_URL = new String[] { "/auth/login", "/auth/register" };
    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }
}
