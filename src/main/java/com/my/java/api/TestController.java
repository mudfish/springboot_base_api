package com.my.java.api;

import com.my.java.service.Service01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 事务传机制测试
 * @Author xusc
 * @Date 2024/5/24
 */
@RestController
@RequestMapping("")
public class TestController {
    @Autowired
    private Service01 service01;

    /**
     * 同类中在方法a中调用b
     *  a没有事务，b有 ，异常发生在a中 不会回滚
     * @return
     */
    @GetMapping("/c1_a0_b1_ea")
    public String test1() {
        service01.c1_a0_b1_ea("c1_a0_b1_ea");
        return "ok";
    }

    /**
     * 同类中在方法a中调用b
     *  a没有事务，b有 ，异常发生在b中 不会回滚
     * @return
     */
    @GetMapping("/c1_a0_b1_eb")
    public String test2() {
        service01.c1_a0_b1_eb("c1_a0_b1_eb");
        return "ok";
    }

    /**
     * 同类中在方法a中调用b
     *  a有事务，b没有 ，异常发生在a中 不会回滚
     * @return
     */
    @GetMapping("/c1_a1_b0_ea")
    public String test3() {
        service01.c1_a1_b0_ea("c1_a1_b0_ea");
        return "ok";
    }

    /**
     * 同类中在方法a中调用b
     *  a有事务，b没有 ，异常发生在b中 不会回滚
     * @return
     */
    @GetMapping("/c1_a1_b0_eb")
    public String test4() {
        service01.c1_a1_b0_eb("c1_a1_b0_eb");
        return "ok";
    }

    /**
     * 同类中在方法a中调用b
     *  a没有事务，b有 ，异常发生在a中 不会回滚
     * @return
     */
    @GetMapping("/c1_a1_b1_ea")
    public String test5() {
        service01.c1_a1_b1_ea("c1_a1_b1_ea");
        return "ok";
    }

    /**
     * 同类中在方法a中调用b
     *  a没有事务，b有 ，异常发生在a中 不会回滚
     * @return
     */
    @GetMapping("/c1_a1_b1_eb")
    public String test6() {
        service01.c1_a1_b1_eb("c1_a1_b1_eb");
        return "ok";
    }


    /**
     * 不同类中在方法a中调用b
     *  a没有事务，b有 ，异常发生在a中 XXXXXXX
     * @return
     */
    @GetMapping("/c0_a0_b1_ea")
    public String test7() {
        service01.c0_a0_b1_ea("c0_a0_b1_ea");
        return "ok";
    }

    /**
     * 不同类中在方法a中调用b
     *  a没有事务，b有 ，异常发生在b中 XXXXXX
     * @return
     */
    @GetMapping("/c0_a0_b1_eb")
    public String test8() {
        service01.c0_a0_b1_eb("c0_a0_b1_eb");
        return "ok";
    }

    /**
     * 不同类中在方法a中调用b
     *  a有事务，b没有 ，异常发生在a中 xxxx
     * @return
     */
    @GetMapping("/c0_a1_b0_ea")
    public String test9() {
        service01.c0_a1_b0_ea("c0_a1_b0_ea");
        return "ok";
    }

    /**
     * 不同类中在方法a中调用b
     *  a有事务，b没有 ，异常发生在b中 xxxxx
     * @return
     */
    @GetMapping("/c0_a1_b0_eb")
    public String test10() {
        service01.c0_a1_b0_eb("c0_a1_b0_eb");
        return "ok";
    }

    /**
     * 不同类中在方法a中调用b
     *  a有事务，b有 ，异常发生在a中 xxxxx
     * @return
     */
    @GetMapping("/c0_a1_b1_ea")
    public String test11() {
        service01.c0_a1_b1_ea("c0_a1_b1_ea");
        return "ok";
    }

    /**
     * 不同类中在方法a中调用b
     *  a没有事务，b有 ，异常发生在b中 xxxxxx
     * @return
     */
    @GetMapping("/c0_a1_b1_eb")
    public String test12() {
        service01.c0_a1_b1_eb("c0_a1_b1_eb");
        return "ok";
    }
}

