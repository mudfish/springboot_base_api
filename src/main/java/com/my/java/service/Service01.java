package com.my.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试事务传播机制，服务01
 */
@Service
public class Service01 extends AbstractUserService{
    @Autowired
    private Service02 service02;

    // 同类调用
    public void c1_a0_b1_ea(String username){
        saveUser(username);
        this.b1(username,false);
        makeException();
    }

    public void c1_a0_b1_eb(String username){
        saveUser(username);
        this.b1(username,true);
    }

    @Transactional(rollbackFor = Exception.class)
    public void c1_a1_b0_ea(String username){
        saveUser(username);
        this.b0(username,false);
        makeException();
    }


    @Transactional(rollbackFor = Exception.class)
    public void c1_a1_b0_eb(String username){
        saveUser(username);
        this.b0(username,true);
    }

    @Transactional(rollbackFor = Exception.class)
    public void c1_a1_b1_ea(String username){
        saveUser(username);
        this.b1(username,false);
        makeException();
    }

    @Transactional(rollbackFor = Exception.class)
    public void c1_a1_b1_eb(String username){
        try{
            saveUser(username);
            this.b1(username,true);
        }catch (Exception e){
            System.out.println("c1_a1_b1_eb执行失败：");
            throw new RuntimeException("c1_a1_b1_eb执行失败");
        }
    }

    // 不同类调用
    public void c0_a0_b1_ea(String username){
        saveUser(username);
        service02.b1(username,false);
        makeException();
    }

    public void c0_a0_b1_eb(String username){
        saveUser(username);
        service02.b1(username,true);
    }

    @Transactional(rollbackFor = Exception.class)
    public void c0_a1_b0_ea(String username){
        saveUser(username);
        service02.b0(username,false);
        makeException();
    }

    @Transactional(rollbackFor = Exception.class)
    public void c0_a1_b0_eb(String username){
        saveUser(username);
        service02.b0(username,true);
    }

    @Transactional(rollbackFor = Exception.class)
    public void c0_a1_b1_ea(String username){
        saveUser(username);
        service02.b1(username,false);
        makeException();
    }

    @Transactional(rollbackFor = Exception.class)
    public void c0_a1_b1_eb(String username){
        saveUser(username);
        service02.b1(username,true);
    }

    public void b0(String username,boolean hasException){
        updatePassword(username);
        if(hasException){
            makeException();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void b1(String username, boolean hasException){
        updatePassword(username);
        if(hasException){
            makeException();
        }
    }




}