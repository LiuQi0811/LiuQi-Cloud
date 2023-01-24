package com.liuqi.system.mapper;

import java.util.List;

/*
 *@ClassName SysMenuMapper
 *@Description 菜单 数据层
 *@Author LiuQi
 *@Date 2023/1/23 08:32
 *@Version 1.0
 */
public interface SysMenuMapper {


    /**
     * 根据角色id查询菜单权限
     *
     * @param roleId 角色id
     * @return 权限列表
     */
    List<String> selectMenuPermsByRoleId(Long roleId);

    /**
     * 根据用户id查询菜单权限
     *
     * @param userId 用户id
     * @return 权限列表
     */
    List<String> selectMenuPermsByUserId(Long userId);
}
