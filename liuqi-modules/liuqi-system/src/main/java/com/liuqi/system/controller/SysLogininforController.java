package com.liuqi.system.controller;

import com.liuqi.common.core.web.controller.BaseController;
import com.liuqi.common.core.web.domain.AjaxResult;
import com.liuqi.system.api.domain.SysLogininfor;
import com.liuqi.system.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@ClassName SysLogininforController
 *@Description 系统访问记录 接口
 *@Author LiuQi
 *@Date 2023/1/25 12:29
 *@Version 1.0
 */
@RestController
@RequestMapping(value = "/logininfor")
public class SysLogininforController extends BaseController {
    @Autowired
    private ISysLogininforService logininforService;

    /**
     * 新增系统登录日志
     */
    @PostMapping
    public AjaxResult add(@RequestBody SysLogininfor sysLogininfor) {
        return toAjax(logininforService.insertLogininfor(sysLogininfor));
    }

}
