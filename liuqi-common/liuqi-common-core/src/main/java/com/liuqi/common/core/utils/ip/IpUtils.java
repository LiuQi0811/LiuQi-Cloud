package com.liuqi.common.core.utils.ip;

import com.liuqi.common.core.utils.StringUtils;
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
    public static String getIpAddr(HttpServletRequest request) {
        log.info("获取客户端IP.......");
        log.info("获取HttpServletRequest {}", request);
        if (request == null) { // 获取request 为空
            return "unknown";
        }
        String ip = null;
        String header = request.getHeader("x-forwarded-for");
        log.info("获取header {}", header);
        ip = header;
        if (header == null || header.length() == 0 || "unknown".equalsIgnoreCase(header)) { // 获取header为空
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (header == null || header.length() == 0 || "unknown".equalsIgnoreCase(header)) { // 获取header为空
            ip = request.getHeader("X-Forwarded-For");
        }
        if (header == null || header.length() == 0 || "unknown".equalsIgnoreCase(header)) { // 获取header为空
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (header == null || header.length() == 0 || "unknown".equalsIgnoreCase(header)) { // 获取header为空
            ip = request.getHeader("X-Real-IP");
        }
        if (header == null || header.length() == 0 || "unknown".equalsIgnoreCase(header)) { // 获取header为空
            ip = request.getRemoteAddr(); //获取本机ip
        }
        log.info("ip: {}", ip);
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            log.info(":::::::::::::  {}", ip);
        } else {

            final String proxyIp = getMultistageReverseProxyIp(ip);
            log.info("***********  {}", proxyIp);
        }

        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : getMultistageReverseProxyIp(ip);
    }


    /**
     * 从多级反向代理中获得第一个非unknown IP地址
     *
     * @param ip 获得的IP地址
     * @return 第一个非unknown IP地址
     */
    public static String getMultistageReverseProxyIp(String ip) {
        log.info("AAA   {}", ip.indexOf(","));
        if (ip != null && ip.indexOf(",") > 0) {
            String[] ips = ip.trim().split(","); // 分割ip
            for (String subIp : ips) { //循环遍历ip列表
                if (false == isUnknown(subIp)) {
                    ip = subIp;
                    break;
                }
            }
        }
        return ip;
    }

    /**
     * 检测给定字符串是否为未知，多用于检测HTTP请求相关
     *
     * @param checkStr 被检测的字符串
     * @return 是否未知
     */
    public static boolean isUnknown(String checkStr) {
        // 被检测的字符串 为空 或者 unknown 返回true
        return StringUtils.isBlank(checkStr) || "unknown".equalsIgnoreCase(checkStr);
    }

}
