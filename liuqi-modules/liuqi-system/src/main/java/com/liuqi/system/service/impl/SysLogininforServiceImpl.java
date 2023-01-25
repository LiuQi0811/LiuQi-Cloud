package com.liuqi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqi.system.api.domain.SysLogininfor;
import com.liuqi.system.mapper.SysLogininforMapper;
import com.liuqi.system.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@ClassName SysLogininforServiceImpl
 *@Description 系统访问日志情况信息 业务层实现
 *@Author LiuQi
 *@Date 2023/1/25 13:01
 *@Version 1.0
 */
@Service
public class SysLogininforServiceImpl extends ServiceImpl<SysLogininforMapper, SysLogininfor> implements ISysLogininforService {
    @Autowired
    private SysLogininforMapper logininforMapper;
    @Override
    public int insertLogininfor(SysLogininfor logininfor) {
        return  logininforMapper.insertLogininfor(logininfor);
    }
}
