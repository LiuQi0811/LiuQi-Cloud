package com.liuqi.gateway.service;

import com.liuqi.common.core.exception.captcha.CaptchaException;
import com.liuqi.common.core.web.domain.AjaxResult;

import java.io.IOException;

/*
 *@ClassName ValidateCodeService
 *@Description 验证码业务处理
 *@Author LiuQi
 *@Date 2023/1/30 08:09
 *@Version 1.0
 */
public interface ValidateCodeService
{
    /**
     * 生成验证码
     * @return
     * @throws IOException
     * @throws CaptchaException
     */
    AjaxResult createCaptcha() throws IOException, CaptchaException;


}
