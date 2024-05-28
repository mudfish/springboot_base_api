package com.my.java.common;

import java.io.Serializable;

/**
* @Description: 统一返回结果
*/
public class ResultUtil<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public ResultUtil() {
    }

    public ResultUtil(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultUtil(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultUtil(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResultUtil(ResultEnum resultStatus, T data) {
        this.code = resultStatus.getCode();
        this.msg = resultStatus.getMessage();
        this.data = data;
    }

    private ResultUtil(String errmsg, T data) {
        this.code = ResultEnum.SYSTEM_ERROR.getCode();
        this.msg = errmsg;
        this.data = data;
    }

    public static ResultUtil<Void> ok() {
        return new ResultUtil<Void>(ResultEnum.SUCCESS, null);
    }


    public static <T> ResultUtil<T> ok(T data) {
        return new ResultUtil<T>(ResultEnum.SUCCESS, data);
    }

    public static <T> ResultUtil<T> ok(ResultEnum resultStatus, T data) {
        if (resultStatus == null) {
            return ok(data);
        }
        return new ResultUtil<T>(resultStatus, data);
    }

    public static <T> ResultUtil<T> error() {
        return new ResultUtil<T>(ResultEnum.SYSTEM_ERROR, null);
    }

    public static <T> ResultUtil<T> error(String errmsg) {
        return new ResultUtil<T>(errmsg, null);
    }

    public static <T> ResultUtil<T> error(ResultEnum resultStatus) {
        return error(resultStatus, null);
    }

    public static <T> ResultUtil<T> error(ResultEnum resultStatus, T data) {
        if (resultStatus == null) {
            return new ResultUtil<T>(ResultEnum.SYSTEM_ERROR, null);
        }
        return new ResultUtil<T>(resultStatus, data);
    }

    public static <T> ResultUtil<T> error(Integer code, String msg) {
        return new ResultUtil<T>(code, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}