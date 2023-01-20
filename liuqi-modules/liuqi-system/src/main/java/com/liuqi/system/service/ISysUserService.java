package com.liuqi.system.service;

import com.liuqi.system.api.domain.SysUser;

import java.util.List;

/*
 *@ClassName ISysUserService
 *@Description 用户 业务层
 *@Author LiuQi
 *@Date 2023/1/19 21:54
 *@Version 1.0
 */
public interface ISysUserService {
    /**
     * 根据条件分页查询用户列表
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    List<SysUser> selectUserList(SysUser user);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    SysUser selectUserByUserName(String userName);
}
