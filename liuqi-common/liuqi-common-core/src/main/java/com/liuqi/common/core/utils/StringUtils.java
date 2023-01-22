package com.liuqi.common.core.utils;

/*
 *@ClassName StringUtils
 *@Description 字符串工具类 基于 apache commons lang3
 *@Author LiuQi
 *@Date 2023/1/17 13:19
 *@Version 1.0
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {


    /**
     *  判断一个对象是否为空
     * @param o Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object o) {
        return o == null;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param o Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object o){return !isNull(o);}
}
