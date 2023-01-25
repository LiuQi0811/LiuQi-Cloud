package com.liuqi.system.api.domain;

import com.liuqi.common.core.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/*
 *@ClassName SysLoginInfor
 *@Description 系统访问记录对象sys_logininfor
 *@Author LiuQi
 *@Date 2023/1/25 12:06
 *@Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysLogininfor extends BaseEntity {
    /**
     * id
     */
    private Long infoId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 状态 0成功 1失败
     */
    private String status;

    /**
     * 地址
     */
    private String ipaddr;

    /**
     * 描述
     */
    private String msg;

    /**
     * 访问时间
     */
    private Date accessTime;
}
