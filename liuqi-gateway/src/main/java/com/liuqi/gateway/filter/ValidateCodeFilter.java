package com.liuqi.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/*
 *@ClassName ValidateCodeFilter
 *@Description 验证码过滤器
 *@Author LiuQi
 *@Date 2023/1/30 20:27
 *@Version 1.0
 */
@Component
@Slf4j
public class ValidateCodeFilter extends AbstractGatewayFilterFactory<Object> {
    private final static String[] VALIDATE_URL = new String[] { "/auth/login", "/auth/register" };
    @Override
    public GatewayFilter apply(Object config) {
        log.info("验证码过滤器......");
        return null;
    }
}
