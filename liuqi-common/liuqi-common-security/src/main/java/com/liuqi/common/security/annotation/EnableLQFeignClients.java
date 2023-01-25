package com.liuqi.common.security.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

/*
 *@ClassName EnableLQFeignClients
 *@Description 自定义feign注解 添加basePackages路径
 *@Author LiuQi
 *@Date 2023/1/25 09:08
 *@Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableLQFeignClients {
    String[] value() default {};

    String[] basePackages() default {"com.liuqi"};

    Class<?>[] basePackageClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    Class<?>[] clients() default {};
}
