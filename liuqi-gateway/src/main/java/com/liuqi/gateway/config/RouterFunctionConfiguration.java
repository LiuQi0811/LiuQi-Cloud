package com.liuqi.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/*
 *@ClassName RouterFunctionConfiguration
 *@Description 路由配置信息
 *@Author LiuQi
 *@Date 2023/1/30 07:32
 *@Version 1.0
 */
@Configuration
@Slf4j
public class RouterFunctionConfiguration {

    /**
     * Spring5 MVC RouterFunction
     * @return
     */
    @Bean
    public RouterFunction routerFunction() {
        log.info("Spring5 MVC RouterFunction");
        final RouterFunction<ServerResponse> route = RouterFunctions.route(RequestPredicates
                .GET("/code")
                .and(
                        RequestPredicates.accept(MediaType.TEXT_PLAIN)), null);
        log.info("网关路由信息：  {}",route);
        return route;
    }
}
