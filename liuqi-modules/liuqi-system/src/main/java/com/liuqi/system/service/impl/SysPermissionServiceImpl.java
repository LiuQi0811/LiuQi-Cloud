package com.liuqi.system.service.impl;

import com.liuqi.system.api.domain.SysUser;
import com.liuqi.system.service.ISysPermissionService;
import com.liuqi.system.service.ISysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    @Autowired
    private ISysRoleService roleService;

    /**
     * 获取角色数据权限
     *
     * @param sysUser 用户信息
     * @return 角色权限信息
     */
    @Override
    public Set<String> getRolePermission(SysUser sysUser) {
        // 定义角色权限列表
        Set<String> roles = new HashSet<>();
        if (sysUser.isAdmin()) { //判断是否是超级管理员
            //拥有所有权限
            // 新增超级管理员 标识
            roles.add("admin");
        }else {
            // 根据用户id 获取角色权限 集合
            Set<String> roleKeys = roleService.selectRolePermissionByUserId(sysUser.getUserId());
            roles.addAll(roleKeys);
        }
        return roles;
    }


    /**
     * 获取菜单数据权限
     *
     * @param sysUser 用户信息
     * @return 菜单权限信息
     */
    @Override
    public Set<String> getMenuPermission(SysUser sysUser) {
        // 定义菜单权限列表
        Set<String> perms = new HashSet<>();
        if (sysUser.isAdmin()) { //判断是否是超级管理员
            //拥有所有权限
            // 新增匹配规则标识
            perms.add("*:*:*");
        }
        return null;
    }
}
