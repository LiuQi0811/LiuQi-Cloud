package com.liuqi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqi.common.core.utils.StringUtils;
import com.liuqi.system.api.domain.SysRole;
import com.liuqi.system.mapper.SysRoleMapper;
import com.liuqi.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *@ClassName SysRoleServiceImpl
 *@Description 角色 业务层处理
 *@Author LiuQi
 *@Date 2023/1/21 09:14
 *@Version 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;


    /**
     * 根据用户id查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        //根据用户id查询角色信息列表
        List<SysRole> perms = roleMapper.selectRolePermissionByUserId(userId);
        //创建权限列表
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms) { //循环遍历 获取角色信息
            if (StringUtils.isNotNull(perm)) { //角色信息 不为空
                //获取 角色权限集合
                String[] roleKeys = perm.getRoleKey().trim().split(",");
                permsSet.addAll(Arrays.asList(roleKeys));
            }
        }

        return permsSet;
    }
}
