package com.liuqi.system.api.client;

import com.liuqi.common.core.constant.ServiceNameConstants;
import com.liuqi.common.core.domain.R;
import com.liuqi.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务
 */
@FeignClient(contextId = "remoteUserFeignClient",value = ServiceNameConstants.SYSTEM_SERVICE,)
public interface RemoteUserFeignClient {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source 请求来源
     * @return 结果
     */
    @GetMapping("/user/info/{username}")
    R<LoginUser> getUserInfo(@PathVariable(value = "username") String username);


}
