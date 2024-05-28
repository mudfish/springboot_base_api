package com.my.java.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author xusc
 * @Date 2024/5/22
 */
@EnableScheduling
@Component
public class CronExpressionTest {
    // 每分钟执行一次
    //@Scheduled(cron = "0 0/1 * * * ?")
    public void sayHello() {
        System.out.println("hello"+System.currentTimeMillis());
    }

}

