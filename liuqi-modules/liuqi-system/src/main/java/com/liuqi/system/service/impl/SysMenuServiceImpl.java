package com.liuqi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqi.common.core.utils.StringUtils;
import com.liuqi.system.api.domain.SysMenu;
import com.liuqi.system.mapper.SysMenuMapper;
import com.liuqi.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
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
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

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
        //创建权限集合
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) { //循环遍历菜单权限列表
            if (StringUtils.isNotEmpty(perm)) { //权限不为空
                //权限集合赋值
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }

        return permsSet;
    }

    /**
     * 根据用户id查询菜单权限
     *
     * @param userId 用户id
     * @return 权限列表
     */
    @Override
    public Set<String> selectMenuPermsByUserId(Long userId) {
        // 根据用户id查询菜单权限
        List<String> perms = menuMapper.selectMenuPermsByUserId(userId);
        //创建权限集合
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) { //循环遍历菜单权限列表
            if (StringUtils.isNotEmpty(perm)) { //权限不为空
                // 权限集合赋值
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }


}
