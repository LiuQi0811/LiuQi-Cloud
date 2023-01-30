package com.liuqi.gateway.service.impl;

import com.google.code.kaptcha.Producer;
import com.liuqi.common.core.constant.CacheConstants;
import com.liuqi.common.core.exception.captcha.CaptchaException;
import com.liuqi.common.core.utils.uuid.IdUtils;
import com.liuqi.common.core.web.domain.AjaxResult;
import com.liuqi.gateway.config.properties.CaptchaProperties;
import com.liuqi.gateway.service.ValidateCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    /**
     * 生成验证码
     *
     * @return
     * @throws IOException
     * @throws CaptchaException
     */
    @Override
    public AjaxResult createCaptcha() throws IOException, CaptchaException {
        final AjaxResult ajax = AjaxResult.success();
        log.info("CaptchaProperties 配置信息 {}", captchaProperties);
        // 验证码开关
        final Boolean captchaEnabled = captchaProperties.getEnabled();
        ajax.put("captchaEnabled", captchaEnabled);
        if (!captchaEnabled) {//验证码未开启
            return ajax;
        }
        // 保存验证码信息
        final String uuid = IdUtils.simpleUUID();
        log.info("验证码 UUID:  {}",uuid);
        final String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;
        log.info("验证码 redis key: {}",verifyKey);

        String captchaStr = null, captchaCode = null;

        // 验证码类型（math 数组计算 char 字符）
        final String captchaType = captchaProperties.getType();
        if(captchaType.equals("math")){ //数组计算 验证码类型
            // 验证码文本
            final String captchaText = captchaProducerMath.createText();
            log.info("验证码文本: {}",captchaText);
        }
        ajax.put("uuid",uuid);
        return ajax;
    }
}
