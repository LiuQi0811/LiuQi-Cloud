package com.liuqi.system.api.client;

import com.liuqi.common.core.constant.ServiceNameConstants;
import com.liuqi.common.core.domain.R;
import com.liuqi.system.api.factory.RemoteUserFallbackFactory;
import com.liuqi.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务
 */
@FeignClient(contextId = "remoteUserFeignClient",name = ServiceNameConstants.SYSTEM_SERVICE,fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserFeignClient {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source 请求来源
     * @return 结果
     */
    @GetMapping(value = "/user/info/{username}",produces = "application/json;charset=utf-8")
    R<LoginUser> getUserInfo(@PathVariable(value = "username") String username);


}
