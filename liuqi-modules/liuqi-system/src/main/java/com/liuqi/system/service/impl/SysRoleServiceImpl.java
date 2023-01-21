package com.liuqi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqi.system.api.domain.SysRole;
import com.liuqi.system.mapper.SysRoleMapper;
import com.liuqi.system.service.ISysRoleService;
import org.springframework.stereotype.Service;

/*
 *@ClassName SysRoleServiceImpl
 *@Description 角色 业务层处理
 *@Author LiuQi
 *@Date 2023/1/21 09:14
 *@Version 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
}
