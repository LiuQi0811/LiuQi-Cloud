package com.liuqi.common.security.service;

import com.liuqi.common.core.constant.CacheConstants;
import com.liuqi.common.core.constant.SecurityConstants;
import com.liuqi.common.core.utils.ServletUtils;
import com.liuqi.common.core.utils.ip.IpUtils;
import com.liuqi.common.core.utils.jwt.JwtUtils;
import com.liuqi.common.core.utils.uuid.IdUtils;
import com.liuqi.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/*
 *@ClassName TokenService
 *@Description token验证处理
 *@Author LiuQi
 *@Date 2023/1/17 09:27
 *@Version 1.0
 */
@Component
@Slf4j
public class TokenService {

    protected static final long MILLIS_SECOND = 1000;
    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;
    // 缓存有效期，默认720（分钟）
    private final static long expireTime = CacheConstants.EXPIRATION;
    private final static String ACCESS_TOKEN = CacheConstants.LOGIN_TOKEN_KEY;

    /**
     * 创建令牌
     *
     * @param loginUser 登录用户信息
     * @return
     */
    public  Map<String, Object> createToken(LoginUser loginUser) {
        //获取封装 uuid
        final String uuid = IdUtils.fastUUID();
        //获取用户id
        final Long userId = loginUser.getSysUser().getUserId();
        //获取用户名称
        final String userName = loginUser.getSysUser().getUserName();
        loginUser.setToken(uuid);
        loginUser.setUserid(userId);
        loginUser.setUsername(userName);
        loginUser.setIpaddr(IpUtils.getIpAddr(ServletUtils.getRequest()));
        // 刷新令牌有效期
        this.refreshToken(loginUser);
        // Jwt存储信息
        Map<String, Object> claimsMap = new HashMap<String, Object>();
        claimsMap.put(SecurityConstants.USER_KEY, uuid);
        claimsMap.put(SecurityConstants.DETAILS_USER_ID, userId);
        claimsMap.put(SecurityConstants.DETAILS_USERNAME, userName);
        // 接口返回信息
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("access_token", JwtUtils.createToken(claimsMap));
        resultMap.put("expires_in", expireTime);
        return resultMap;
    }


    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(LoginUser loginUser) {
        //登录时间
        loginUser.setLoginTime(System.currentTimeMillis());
        // 过期时间
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存
        final String key = this.getTokenKey(loginUser.getToken());
        log.info("获取token key： {}",key);
        // 存入redis 缓存
    }

    /**
     * 获取token key
     * @param token 令牌
     * @return
     */
    public String getTokenKey(String token)
    {
        return ACCESS_TOKEN + token;
    }
}
