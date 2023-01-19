package com.liuqi.common.core.domain;

import com.liuqi.common.core.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 *@ClassName R
 *@Description 结果🔙 响应信息主体
 *@Author LiuQi
 *@Date 2023/1/19 09:09
 *@Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = Constants.SUCCESS;

    /**
     * 失败
     */
    public static final int FAIL = Constants.FAIL;

    /**
     * 结果返回码
     */
    private int code;

    /**
     * 结果返回消息
     */
    private String msg;

    /**
     * 结果返回响应信息主体内容
     */
    private T data;

    public static <T> R<T> ok(T data){
        return restResult(data,SUCCESS,null);
    }

    private static <T> R<T> restResult(T data, int code, String msg)
    {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }


}
