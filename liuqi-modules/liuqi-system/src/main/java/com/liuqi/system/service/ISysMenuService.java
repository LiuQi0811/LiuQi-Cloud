package com.liuqi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqi.system.api.domain.SysMenu;

import java.util.Set;

/*
 *@ClassName ISysMenuService
 *@Description 菜单 业务层
 *@Author LiuQi
 *@Date 2023/1/23 08:29
 *@Version 1.0
 */
public interface ISysMenuService extends IService<SysMenu>
{
    /**
     * 根据角色id查询菜单权限
     *
     * @param roleId 角色id
     * @return 权限列表
     */
    Set<String> selectMenuPermsByRoleId(Long roleId);
    /**
     * 根据用户id查询菜单权限
     *
     * @param userId 用户id
     * @return 权限列表
     */
    Set<String> selectMenuPermsByUserId(Long userId);
}
