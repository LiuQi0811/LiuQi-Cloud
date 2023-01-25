package com.liuqi.system.api.factory;

import com.liuqi.common.core.domain.R;
import com.liuqi.system.api.client.RemoteUserFeignClient;
import com.liuqi.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/*
 *@ClassName RemoteUserFallbackFactory
 *@Description 用户服务降级处理
 *@Author LiuQi
 *@Date 2023/1/25 08:54
 *@Version 1.0
 */
@Component
@Slf4j
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserFeignClient> {


    @Override
    public RemoteUserFeignClient create(Throwable cause) {
        log.error("用户服务调用失败:{}", cause.getMessage());
        return new RemoteUserFeignClient() {
            @Override
            public R<LoginUser> getUserInfo(String username) {
                return R.fail("获取用户失败:" + cause.getMessage());
            }
        };
    }
}
