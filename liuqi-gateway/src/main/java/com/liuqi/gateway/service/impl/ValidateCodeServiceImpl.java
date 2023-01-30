package com.liuqi.gateway.service.impl;

import com.liuqi.common.core.exception.captcha.CaptchaException;
import com.liuqi.common.core.web.domain.AjaxResult;
import com.liuqi.gateway.config.properties.CaptchaProperties;
import com.liuqi.gateway.service.ValidateCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*
 *@ClassName ValidateCodeServiceImpl
 *@Description 验证码业务实现处理
 *@Author LiuQi
 *@Date 2023/1/30 08:12
 *@Version 1.0
 */
@Component
@Slf4j
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Autowired
    private CaptchaProperties captchaProperties;

    /**
     * 生成验证码
     * @return
     * @throws IOException
     * @throws CaptchaException
     */
    @Override
    public AjaxResult createCaptcha() throws IOException, CaptchaException {
        final AjaxResult ajax = AjaxResult.success();
        log.info("CaptchaProperties 配置信息 {}",captchaProperties);
        return ajax;
    }
}
