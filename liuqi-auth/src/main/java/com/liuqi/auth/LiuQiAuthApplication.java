package com.liuqi.auth;

import com.liuqi.common.security.annotation.EnableLQFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 认证授权中心 启动类
 */
@EnableLQFeignClients //自定义feign注解 内部开启EnableFeignClients注解
@SpringBootApplication
public class LiuQiAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiuQiAuthApplication.class, args);
    }
}
