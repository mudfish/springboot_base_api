package com.my.java.common;

import cn.hutool.http.HttpStatus;


public enum ResultEnum {
    SUCCESS(HttpStatus.HTTP_OK, "OK"),
    FORBIDDEN(HttpStatus.HTTP_FORBIDDEN,  "系统禁止"),
    UNAUTHORIZED(HttpStatus.HTTP_UNAUTHORIZED, "操作未授权"),
    BAD_REQUEST(HttpStatus.HTTP_BAD_REQUEST, "错误请求"),
    SYSTEM_ERROR(HttpStatus.HTTP_INTERNAL_ERROR, "系统异常");


    private HttpStatus httpStatus;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResultEnum{" +
                "httpStatus=" + httpStatus +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
