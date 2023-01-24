package com.liuqi.system.service.impl;

import com.liuqi.system.mapper.SysMenuMapper;
import com.liuqi.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/*
 *@ClassName SysMenuServiceImpl
 *@Description 菜单 业务层处理
 *@Author LiuQi
 *@Date 2023/1/23 08:31
 *@Version 1.0
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;
    /**
     * 根据角色id查询菜单权限
     *
     * @param roleId 角色id
     * @return 权限列表
     */
    @Override
    public Set<String> selectMenuPermsByRoleId(Long roleId) {
        // 根据角色id获取菜单权限
        List<String> perms = menuMapper.selectMenuPermsByRoleId(roleId);
        return null;
    }
}
