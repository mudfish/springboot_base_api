package com.my.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.my.java.dao")
@SpringBootApplication
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}
