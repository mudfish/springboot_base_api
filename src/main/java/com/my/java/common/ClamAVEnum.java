package com.my.java.common;

import lombok.Getter;
 
/**
 * 文件杀毒 返回结果枚举类
 */
 
@Getter
public enum ClamAVEnum {
 
    OK("stream: OK\u0000","ok",1,"文件无病毒"),
    ALLOCATE_MEMORY("stream: Can't allocate memory ERROR\u0000","allocate_memory",-1,"文件超出杀毒服务最大文件限制"),
    INFECTED("stream:INFECTED ","Infected",-1,"文件存在病毒");
 
    private String code;
    private String msg;
    private Integer result;
    private String desc;
 
    ClamAVEnum(String code, String msg, Integer result, String desc) {
        this.code = code;
        this.msg = msg;
        this.result = result;
        this.desc = desc;
    }
}