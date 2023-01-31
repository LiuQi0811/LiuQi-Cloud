package com.liuqi.common.core.utils.jwt;

import com.liuqi.common.core.constant.SecurityConstants;
import com.liuqi.common.core.constant.TokenConstants;
import com.liuqi.common.core.text.Convert;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/*
 *@ClassName JwtUtils
 *@Description Jwt工具类
 *@Author LiuQi
 *@Date 2023/1/29 08:04
 *@Version 1.0
 */
@Slf4j
public class JwtUtils {

    //token 密钥
    public static String secret = TokenConstants.SECRET;

    /**
     * 从数据声明生成令牌
     * @param claims 数据声明 载赫
     * @return 令牌
     */
    public static String createToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * 根据令牌获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public static String getUserName(String token){
        final Claims claims = parseToken(token);
        log.info("从令牌中获取数据声明信息: {}",claims);
        final String value = getValue(claims, SecurityConstants.DETAILS_USERNAME);
        log.info("根据令牌获取用户名： {}",value);
        return value;
    }

    /**
     * 从令牌中获取数据声明
     * @param token
     * @return 载核信息 数据声明
     */
    public static Claims parseToken(String token){
        //获取载核信息 1.密钥 2.token令牌 3.body 内容主体
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }


    /**
     * 根据身份信息获取键值
     *
     * @param claims 身份信息
     * @param key 键
     * @return 值
     */
    public static String getValue(Claims claims, String key)
    {
        return Convert.toStr(claims.get(key), "");

    }

}
