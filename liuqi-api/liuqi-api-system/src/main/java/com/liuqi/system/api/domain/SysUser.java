package com.liuqi.system.api.domain;

import com.liuqi.common.core.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/*
 *@ClassName SysUser
 *@Description 用户对象 sys_user
 *@Author LiuQi
 *@Date 2023/1/17 12:13
 *@Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUser extends BaseEntity {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 密码
     */
    private String password;
    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;
    /**
     * 最后登录IP
     */
    private String loginIp;
    /**
     * 最后登录时间
     */
    private Date loginDate;
    /**
     * 部门对象
     */
    private SysDept dept;
    /**
     * 角色对象组
     */
    private List<SysRole> roles;
    /**
     * 角色组
     */
    private Long[] roleIds;
    /**
     * 岗位组
     */
    private Long[] postIds;
    /**
     * 角色ID
     */
    private Long roleId;


    public boolean isAdmin() { //判断 是否是超级管理员封装
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId) { //是否是超级管理员
        // userId 不为空 并且 等于 1L
        return userId != null && userId == 1L;
    }
}
