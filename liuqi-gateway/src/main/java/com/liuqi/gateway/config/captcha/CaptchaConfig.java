package com.liuqi.gateway.config.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static com.google.code.kaptcha.Constants.KAPTCHA_BORDER;

/*
 *@ClassName CaptchaConfig
 *@Description 验证码配置类
 *@Author LiuQi
 *@Date 2023/1/30 09:11
 *@Version 1.0
 */
@Configuration
@Slf4j
public class CaptchaConfig {

    /**
     * math 数组计算 验证码
     * @return
     */
    @Bean(name = "captchaProducerMath")
    public DefaultKaptcha getDefaultKaptChaMathBean() {
        // 创建验证码对象
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        //创建读取Java配置对象
        final Properties properties = new Properties();
        // 是否有边框 默认为true 我们可以自己设置yes，no
        properties.setProperty(KAPTCHA_BORDER,"yes");

        // 创建验证码配置对象
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        log.info("验证码对象 信息:  {}",defaultKaptcha);
        return defaultKaptcha;
    }
}
