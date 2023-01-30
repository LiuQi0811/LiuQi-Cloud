package com.liuqi.gateway.handler;

import com.liuqi.common.core.exception.captcha.CaptchaException;
import com.liuqi.common.core.web.domain.AjaxResult;
import com.liuqi.gateway.service.ValidateCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

/*
 *@ClassName ValidateCodeHandler
 *@Description 验证码获取 验证码处理程序
 *@Author LiuQi
 *@Date 2023/1/30 07:48
 *@Version 1.0
 */
@Component
@Slf4j
public class ValidateCodeHandler implements HandlerFunction<ServerResponse> {

    @Autowired
    private ValidateCodeService validateCodeService;

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        log.info("验证码获取 ServerRequest 对象  {}", request);
        AjaxResult ajax;
        try {
            //  创建验证码
            ajax = validateCodeService.createCaptcha();
        } catch (CaptchaException | IOException e) {
            return Mono.error(e);
        }
        return ServerResponse.status(HttpStatus.OK)
                .body(BodyInserters.fromValue(ajax));
    }
}
