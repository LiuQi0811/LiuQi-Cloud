package com.liuqi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqi.system.api.domain.SysUser;

import java.util.List;

/*
 *@ClassName SysUserMapper
 *@Description 用户 数据层
 *@Author LiuQi
 *@Date 2023/1/19 22:01
 *@Version 1.0
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据条件分页查询用户列表
     *
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
    List<SysUser> selectUserList(SysUser sysUser);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    SysUser selectUserByUserName(String userName);
}
