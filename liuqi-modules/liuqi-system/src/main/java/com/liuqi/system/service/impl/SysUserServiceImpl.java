package com.liuqi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqi.system.api.domain.SysUser;
import com.liuqi.system.mapper.SysUserMapper;
import com.liuqi.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@ClassName SysUserServiceImpl
 *@Description 用户 业务层处理
 *@Author LiuQi
 *@Date 2023/1/19 21:59
 *@Version 1.0
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;
    /**
     * 根据条件分页查询用户列表
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
    @Override
    public List<SysUser> selectUserList(SysUser sysUser) {
        return userMapper.selectUserList(sysUser);
    }

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }
}
