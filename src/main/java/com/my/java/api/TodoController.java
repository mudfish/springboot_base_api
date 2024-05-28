package com.my.java.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.my.java.common.ResultUtil;
import com.my.java.entity.TodoEntity;
import com.my.java.entity.req.TodoReq;
import com.my.java.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("queryList")
    public ResultUtil<List<TodoEntity>> get(@RequestBody TodoReq param){
        List<TodoEntity> list = todoService.list(new LambdaQueryWrapper<TodoEntity>()
                .like(StringUtils.isNotBlank(param.getTitle()), TodoEntity::getTitle,param.getTitle())
                .eq(param.getDone()!=null, TodoEntity::getDone,param.getDone())
                .eq(StringUtils.isNotBlank(param.getLastDate()), TodoEntity::getLastDate,param.getLastDate())
                .eq(param.getUserId()!=null,TodoEntity::getUserId,param.getUserId())
                .orderByAsc(TodoEntity::getLastDate)
        );
        return ResultUtil.ok(list);
    }

    @PostMapping("count")
    public ResultUtil<Integer> count(@RequestBody TodoReq param){
        Integer count = todoService.count(new LambdaQueryWrapper<TodoEntity>()
                .like(StringUtils.isNotBlank(param.getTitle()), TodoEntity::getTitle,param.getTitle())
                .eq(param.getDone()!=null, TodoEntity::getDone,param.getDone())
                .eq(StringUtils.isNotBlank(param.getLastDate()), TodoEntity::getLastDate,param.getLastDate())
                .eq(param.getUserId()!=null,TodoEntity::getUserId,param.getUserId())
                .orderByAsc(TodoEntity::getLastDate)
        );
        return ResultUtil.ok(count);
    }

    @PostMapping("insert")
    public ResultUtil<TodoEntity> add(@RequestBody TodoEntity entity){
        if(StringUtils.isBlank(entity.getTitle())){
            return  ResultUtil.error("参数不合法");
        }
        boolean saved = todoService.save(entity);
        if(saved){
            return ResultUtil.ok(entity);
        }
        return ResultUtil.error("系统异常");
    }

    @PostMapping("updateStatus")
    public ResultUtil<String> updateStatus(@RequestBody TodoEntity entity){
        if(entity.getId()==null){
            return ResultUtil.error("待办不存在！");
        }
        todoService.update(new LambdaUpdateWrapper<TodoEntity>().set(TodoEntity::getDone,entity.getDone()).eq(TodoEntity::getId,entity.getId()));
        return ResultUtil.ok("ok");
    }

    @PostMapping("update")
    public ResultUtil<TodoEntity> update(@RequestBody TodoEntity entity){
        if(entity.getId()==null){
            return ResultUtil.error("待办不存在！");
        }
        todoService.updateById(entity);
        return ResultUtil.ok(entity);
    }

    @PostMapping("delete")
    public ResultUtil<String> delete(@RequestParam Integer id){
        todoService.removeById(id);
        return ResultUtil.ok("ok");
    }


    @GetMapping("getOne")
    public ResultUtil<TodoEntity> get(@RequestParam Integer id){
        TodoEntity user = todoService.getById(id);
        return ResultUtil.ok(user);
    }
}
