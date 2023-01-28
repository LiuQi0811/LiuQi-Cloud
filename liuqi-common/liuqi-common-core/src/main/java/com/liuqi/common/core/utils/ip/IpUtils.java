package com.liuqi.common.core.utils.ip;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/*
 *@ClassName IpUtils
 *@Description 获取IP工具方法
 *@Author LiuQi
 *@Date 2023/1/25 14:06
 *@Version 1.0
 */
@Slf4j
public class IpUtils {

    /**
     * 获取客户端IP
     *
     * @param request 请求对象
     * @return IP地址
     */
    public static String getIpAddr(HttpServletRequest request){
        log.info("获取客户端IP.......");
        log.info("获取HttpServletRequest {}",request);
        if (request==null) { // 获取request 为空
            return "unknown";
        }
        String ip = null;
        String header = request.getHeader("x-forwarded-for");
        log.info("获取header {}",header);
        if(header==null||header.length()==0||"unknown".equalsIgnoreCase(header)){ // 获取header为空
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(header==null||header.length()==0||"unknown".equalsIgnoreCase(header)){ // 获取header为空
            ip = request.getHeader("X-Forwarded-For");
        }
        if(header==null||header.length()==0||"unknown".equalsIgnoreCase(header)){ // 获取header为空
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(header==null||header.length()==0||"unknown".equalsIgnoreCase(header)){ // 获取header为空
            ip = request.getHeader("X-Real-IP");
        }
        if(header==null||header.length()==0||"unknown".equalsIgnoreCase(header)){ // 获取header为空
            ip = request.getRemoteAddr(); //获取本机ip
        }
        log.info("ip: {}",ip);
        if("0:0:0:0:0:0:0:1".equals(ip)){
            log.info(":::::::::::::");
        }else {
            log.info("***********");
        }

        return null;
    }
}
