package com.liuqi.common.core.utils.uuid;

import lombok.extern.slf4j.Slf4j;

/*
 *@ClassName IdUtils
 *@Description id生成器工具类
 *@Author LiuQi
 *@Date 2023/1/28 11:30
 *@Version 1.0
 */
@Slf4j
public class IdUtils {

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 随机UUID
     */
    public static String fastUUID() {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID()
    {
        return UUID.randomUUID().toString(true);
    }
}
