package com.liuqi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqi.system.api.domain.SysRole;

import java.util.List;
import java.util.Set;

/*
 *@ClassName ISysRoleService
 *@Description 角色 业务层
 *@Author LiuQi
 *@Date 2023/1/21 09:13
 *@Version 1.0
 */
public interface ISysRoleService extends IService<SysRole> {
    /**
     * 根据用户id查询角色权限
     *
     * @param userId 用户id
     * @return 角色列表
     */
    Set<String> selectRolePermissionByUserId(Long userId);
}
