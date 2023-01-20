package com.liuqi.system.service;

import com.liuqi.system.api.domain.SysUser;

import java.util.Set;

/*
 *@ClassName ISysPermissionService
 *@Description 权限信息 业务层
 *@Author LiuQi
 *@Date 2023/1/20 21:44
 *@Version 1.0
 */
public interface ISysPermissionService {
    /**
     * 获取角色数据权限
     *
     * @param sysUser 用户信息
     * @return 角色权限信息
     */
    Set<String> getRolePermission(SysUser sysUser);

    /**
     * 获取菜单数据权限
     *
     * @param sysUser 用户信息
     * @return 菜单权限信息
     */
    Set<String> getMenuPermission(SysUser sysUser);
}
