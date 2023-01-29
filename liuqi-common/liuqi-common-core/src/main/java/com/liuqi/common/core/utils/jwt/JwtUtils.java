package com.liuqi.common.core.utils.jwt;

import com.liuqi.common.core.constant.TokenConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;

/*
 *@ClassName JwtUtils
 *@Description Jwt工具类
 *@Author LiuQi
 *@Date 2023/1/29 08:04
 *@Version 1.0
 */
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

}
