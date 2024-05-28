package com.my.java.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.java.dao.TodoDao;
import com.my.java.entity.TodoEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl extends ServiceImpl<TodoDao, TodoEntity> implements TodoService {

}
