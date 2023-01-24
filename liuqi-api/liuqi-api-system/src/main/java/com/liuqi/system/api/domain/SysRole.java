package com.liuqi.system.api.domain;

import com.liuqi.common.core.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/*
 *@ClassName SysRole
 *@Description 角色对象 sys_role
 *@Author LiuQi
 *@Date 2023/1/17 12:22
 *@Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysRole extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色权限
     */
    private String roleKey;
    /**
     * 角色排序
     */
    private Integer roleSort;
    /**
     * 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）
     */
    private String dataScope;
    /**
     * 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）
     */
    private boolean menuCheckStrictly;
    /**
     * 部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）
     */
    private boolean deptCheckStrictly;
    /**
     * 角色状态（0正常 1停用）
     */
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;
    /**
     * 用户是否存在此角色标识 默认不存在
     */
    private boolean flag = false;
    /**
     * 菜单组
     */
    private Long[] menuIds;
    /**
     * 部门组（数据权限）
     */
    private Long[] deptIds;
    /**
     * 角色菜单权限
     */
    private Set<String> permissions;

}
