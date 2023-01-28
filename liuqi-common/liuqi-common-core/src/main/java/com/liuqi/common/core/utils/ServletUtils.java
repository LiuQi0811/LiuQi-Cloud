package com.liuqi.common.core.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/*
 *@ClassName ServletUtils
 *@Description 客户端工具类
 *@Author LiuQi
 *@Date 2023/1/28 10:02
 *@Version 1.0
 */
public class ServletUtils {


    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        try {
            return getRequestAttributes().getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取request作用域
     *
     * @return
     */
    public static ServletRequestAttributes getRequestAttributes() {
        // 获取request作用域
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes);
    }
}
