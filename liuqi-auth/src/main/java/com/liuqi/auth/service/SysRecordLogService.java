package com.liuqi.auth.service;

import com.liuqi.system.api.client.RemoteLogFeignClient;
import org.springframework.beans.factory.annotation.Autowired;

/*
 *@ClassName SysRecordLogService
 *@Description 记录日志方法
 *@Author LiuQi
 *@Date 2023/1/25 12:15
 *@Version 1.0
 */
public class SysRecordLogService {
    @Autowired
    private RemoteLogFeignClient remoteLogFeignClient;
}
