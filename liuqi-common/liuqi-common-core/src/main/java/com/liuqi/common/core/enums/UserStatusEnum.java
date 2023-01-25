package com.liuqi.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态枚举
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum {
    OK("0", "正常"), DISABLE("1", "停用"), DELETED("2", "删除");
    private final String code;
    private final String info;
}
