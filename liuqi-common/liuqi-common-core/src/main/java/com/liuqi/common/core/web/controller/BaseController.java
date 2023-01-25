package com.liuqi.common.core.web.controller;

import com.liuqi.common.core.web.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;

/*
 *@ClassName BaseController
 *@Description web层通用数据处理
 *@Author LiuQi
 *@Date 2023/1/25 13:15
 *@Version 1.0
 */
@Slf4j
public class BaseController {
    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows){
        return rows> 0? AjaxResult.success():AjaxResult.error();
    }
}
