package com.my.java.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.my.java.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author xusc
 * @Date 2024/5/24
 */
@Service
public class AbstractUserService {
    @Autowired
    private UserService userService;

    /**
     *  新增用户
     * @param username
     */
    public void saveUser(String username) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userService.save(userEntity);
    }

    /**
     *  更新密码
     * @param username
     */
    public void updatePassword(String username) {
        UserEntity entity = userService.getOne(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getUsername,username));
        entity.setPassword("123456");
        userService.updateById(entity);
    }

    /**
     * 制造异常
     */
    public void makeException() {
        int i=1/0;
    }
}

