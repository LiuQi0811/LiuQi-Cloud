package com.liuqi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqi.system.api.domain.SysLogininfor;

/*
 *@ClassName ISysLogininforService
 *@Description 系统访问日志情况信息 业务层
 * *
 *@Author LiuQi
 *@Date 2023/1/25 12:30
 *@Version 1.0
 */
public interface ISysLogininforService extends IService<SysLogininfor> {
    /**
     * 新增系统登录日志
     * @param logininfor 访问日志对象
     * @return
     */
    int insertLogininfor(SysLogininfor logininfor);
}
