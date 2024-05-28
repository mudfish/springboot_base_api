package com.my.java.test;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Description TODO
 * @Author xusucheng
 * @Date 2024/4/23
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        String dateStr1 = "2024-04-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);
        long betweenDay = DateUtil.between(date1, DateUtil.date(), DateUnit.DAY);
        System.out.println(betweenDay);
    }
}
