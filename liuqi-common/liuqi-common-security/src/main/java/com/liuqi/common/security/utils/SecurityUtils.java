package com.liuqi.common.security.utils;

import com.liuqi.common.core.constant.TokenConstants;
import com.liuqi.common.core.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/*
 *@ClassName SecurityUtils
 *@Description 权限获取工具类
 *@Author LiuQi
 *@Date 2023/1/31 09:52
 *@Version 1.0
 */
@Slf4j
public class SecurityUtils {


    /**
     * 根据request获取请求token
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request){

        // 从header获取token标识
        final String token = request.getHeader(TokenConstants.AUTHENTICATION);
        log.info("从header获取token标识: {}",token);
        return replaceTokenPrefix(token);
    }

    /**
     *  替换裁剪token前缀
     * @param token
     * @return
     */
    public static String replaceTokenPrefix(String token){
        // 如果前端设置了令牌前缀，则裁剪掉前缀
        if (StringUtils.isNotEmpty(token) && token.startsWith(TokenConstants.PREFIX))
        {
            // Bearer 替换 ""
            token =token.replaceFirst(TokenConstants.PREFIX,"");
            log.info("裁剪掉前缀的 token: {}",token);
        }
        return token;
    }
}
