package com.liuqi.common.core.exception.util;

/*
 *@ClassName UtilException
 *@Description 工具类异常
 *@Author LiuQi
 *@Date 2023/1/28 17:14
 *@Version 1.0
 */
public class UtilException extends RuntimeException {
    private static final long serialVersionUID = 8247610319171014183L;
    public UtilException(Throwable throwable){
        super(throwable.getMessage(),throwable);
    }
    public UtilException(String message)
    {
        super(message);
    }
    public UtilException(String message, Throwable throwable)
    {
        super(message, throwable);
    }

}
