package com.liuqi.system.service.impl;

import com.liuqi.system.api.domain.SysUser;
import com.liuqi.system.service.ISysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

/*
 *@ClassName SysPermissionServiceImpl
 *@Description 权限信息 业务层处理
 *@Author LiuQi
 *@Date 2023/1/20 21:46
 *@Version 1.0
 */
@Service
@Slf4j
public class SysPermissionServiceImpl implements ISysPermissionService {


    /**
     * 获取角色数据权限
     *
     * @param sysUser 用户信息
     * @return 角色权限信息
     */
    @Override
    public Set<String> getRolePermission(SysUser sysUser) {
        return null;
    }


    /**
     * 获取菜单数据权限
     *
     * @param sysUser 用户信息
     * @return 菜单权限信息
     */
    @Override
    public Set<String> getMenuPermission(SysUser sysUser) {
        return null;
    }
}
