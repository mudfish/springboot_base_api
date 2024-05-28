package com.my.java.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.java.dao.UserDao;
import com.my.java.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

}
