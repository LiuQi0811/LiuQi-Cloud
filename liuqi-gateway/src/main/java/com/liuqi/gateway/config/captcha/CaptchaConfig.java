package com.liuqi.gateway.config.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *@ClassName CaptchaConfig
 *@Description 验证码配置
 *@Author LiuQi
 *@Date 2023/1/30 09:11
 *@Version 1.0
 */
@Configuration
public class CaptchaConfig {

    @Bean(name = "captchaProducerMath")
    public DefaultKaptcha getDefaultKaptChaBean() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        return defaultKaptcha;
    }
}
