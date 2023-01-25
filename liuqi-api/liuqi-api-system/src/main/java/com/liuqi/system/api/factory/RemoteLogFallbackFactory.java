package com.liuqi.system.api.factory;

import com.liuqi.common.core.domain.R;
import com.liuqi.system.api.client.RemoteLogFeignClient;
import com.liuqi.system.api.domain.SysLogininfor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/*
 *@ClassName RemoteLogFallbackFactory
 *@Description 日志服务降级处理
 *@Author LiuQi
 *@Date 2023/1/25 13:34
 *@Version 1.0
 */
@Slf4j
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogFeignClient> {
    @Override
    public RemoteLogFeignClient create(Throwable cause) {
        log.error("日志服务调用失败:{}", cause.getMessage());
        return new RemoteLogFeignClient() {
            @Override
            public R<Boolean> saveLogininfor(SysLogininfor sysLogininfor) {
                return null;
            }
        };
    }
}
