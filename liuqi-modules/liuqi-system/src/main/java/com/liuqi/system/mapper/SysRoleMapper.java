package com.liuqi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqi.system.api.domain.SysRole;

import java.util.List;

/*
 *@ClassName SysRoleMapper
 *@Description 角色 数据层
 *@Author LiuQi
 *@Date 2023/1/21 09:15
 *@Version 1.0
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<SysRole> selectRolePermissionByUserId(Long userId);
}
