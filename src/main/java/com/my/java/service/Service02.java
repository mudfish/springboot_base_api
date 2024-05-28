package com.my.java.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试事务传播机制，服务02
 */
@Service
public class Service02 extends AbstractUserService{

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