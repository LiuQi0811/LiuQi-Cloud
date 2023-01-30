package com.liuqi.gateway.config.properties;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/*
 *@ClassName CaptchaProperties
 *@Description 验证码配置读取
 *@Author LiuQi
 *@Date 2023/1/30 08:21
 *@Version 1.0
 */
@Configuration
@RefreshScope //@RefreshScope能够支持配置信息的刷新
@ConfigurationProperties(prefix = "security.captcha")
@Data
public class CaptchaProperties {
    /**
     * 验证码开关
     */
    private Boolean enabled;

    /**
     * 验证码类型（math 数组计算 char 字符）
     */
    private String type;
}
