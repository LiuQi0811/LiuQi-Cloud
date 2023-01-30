package com.liuqi.common.core.exception.captcha;

/*
 *@ClassName CaptchaException
 *@Description 验证码错误异常类
 *@Author LiuQi
 *@Date 2023/1/30 08:06
 *@Version 1.0
 */
public class CaptchaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CaptchaException(String msg) {
        super(msg);
    }
}
