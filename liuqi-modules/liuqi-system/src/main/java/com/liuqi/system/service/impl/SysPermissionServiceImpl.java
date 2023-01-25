package com.liuqi.system.service.impl;

import com.liuqi.system.api.domain.SysRole;
import com.liuqi.system.api.domain.SysUser;
import com.liuqi.system.service.ISysMenuService;
import com.liuqi.system.service.ISysPermissionService;
import com.liuqi.system.service.ISysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
    @Autowired
    private ISysMenuService menuService;

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
        } else {
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
        } else {
            //获取角色列表
            List<SysRole> roles = sysUser.getRoles();
            if (!roles.isEmpty() && roles.size() > 1) { //判断角色列表是否为空 长度

                // 多角色设置permissions属性，以便数据权限匹配权限
                for (SysRole role : roles) { //循环遍历角色集合
                    // 根据角色id查询菜单权限
                    Set<String> rolePerms = menuService.selectMenuPermsByRoleId(role.getRoleId());
                    role.setPermissions(rolePerms);
                    perms.addAll(rolePerms);
                }
            }else { //角色列表不为空 直接返回结果
                perms.addAll(menuService.selectMenuPermsByUserId(sysUser.getUserId()));
            }
        }
        return perms;
    }
}
