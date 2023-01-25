package com.liuqi.system.api.client;

import com.liuqi.common.core.constant.ServiceNameConstants;
import com.liuqi.common.core.domain.R;
import com.liuqi.system.api.domain.SysLogininfor;
import com.liuqi.system.api.factory.RemoteLogFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*
 *@ClassName RemoteLogFeignClient
 *@Description 日志服务
 *@Author LiuQi
 *@Date 2023/1/25 12:18
 *@Version 1.0
 */
@FeignClient(contextId = "remoteLogFeignClient",name = ServiceNameConstants.SYSTEM_SERVICE,fallbackFactory = RemoteLogFallbackFactory.class)
public interface RemoteLogFeignClient {
    /**
     *  保存日志访问记录
     * @param sysLogininfor 访问实体
     * @return 结果
     */
    @PostMapping(value = "/logininfor/save")
    R<Boolean>saveLogininfor(@RequestBody SysLogininfor sysLogininfor);
}
