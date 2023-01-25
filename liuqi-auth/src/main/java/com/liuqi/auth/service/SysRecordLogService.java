package com.liuqi.auth.service;

import com.liuqi.common.core.constant.Constants;
import com.liuqi.common.core.utils.StringUtils;
import com.liuqi.system.api.client.RemoteLogFeignClient;
import com.liuqi.system.api.domain.SysLogininfor;
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

    /**
     * 记录登录信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息内容
     * @return
     */
    public void recordLogininfor(String username, String status, String message) {
        SysLogininfor sysLogininfor = SysLogininfor.builder()
                .userName(username)
                .status(status)
                .msg(message)
                .build();
        // 日志状态
        if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER)) { // Success Logout Register
            sysLogininfor.setStatus(Constants.LOGIN_SUCCESS_STATUS);
        } else if (Constants.LOGIN_FAIL.equals(status)) { //ERROR
            sysLogininfor.setStatus(Constants.LOGIN_FAIL_STATUS);
        }
        //新增登录日志记录
        remoteLogFeignClient.saveLogininfor(sysLogininfor);
    }
}
