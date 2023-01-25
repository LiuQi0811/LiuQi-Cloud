package com.liuqi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqi.system.api.domain.SysLogininfor;

/*
 *@ClassName SysLogininforMapper
 *@Description 系统访问日志情况信息 数据层
 *@Author LiuQi
 *@Date 2023/1/25 12:33
 *@Version 1.0
 */
public interface SysLogininforMapper extends BaseMapper<SysLogininfor> {
    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    int insertLogininfor(SysLogininfor logininfor);
}
