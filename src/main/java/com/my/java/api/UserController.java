package com.my.java.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.my.java.common.ResultUtil;
import com.my.java.entity.UserEntity;
import com.my.java.entity.req.UserReq;
import com.my.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("doLogin")
    public ResultUtil<UserEntity> login(@RequestBody UserEntity user){
        List<UserEntity> list = userService.list(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getUsername, user.getUsername()).eq(UserEntity::getPassword, user.getPassword()));
        if(CollectionUtils.isEmpty(list)){
            return ResultUtil.error("用户名或密码错误！");
        }

        UserEntity entity = list.get(0);
        return ResultUtil.ok(entity);
    }

    @PostMapping("reg")
    public ResultUtil<UserEntity> register(@RequestBody UserReq userReq){
        if(StringUtils.isBlank(userReq.getUsername())
                || StringUtils.isBlank(userReq.getPassword())){
            return  ResultUtil.error("请求参数缺失");
        }

        if(!userReq.getPassword().equals(userReq.getPassword2())){
            return  ResultUtil.error("两次密码不一致");
        }

        int count = userService.count(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getUsername, userReq.getUsername()));
        if(count > 0){
            return  ResultUtil.error("用户重复！");
        }
        UserEntity user = new UserEntity();
        user.setPassword(userReq.getPassword());
        user.setUsername(userReq.getUsername());
        user.setNickname(userReq.getNickname());
        userService.save(user);

        return ResultUtil.ok(user);
    }

    @PostMapping("update")
    public ResultUtil<UserEntity> save(@RequestBody UserEntity user){
        if(user.getId()==null){
            return ResultUtil.error("用户未找到");
        }

        userService.updateById(user);

        return ResultUtil.ok(user);
    }



    @PostMapping("doLogout")
    public ResultUtil<String> logout(HttpServletRequest request){
        return ResultUtil.ok("ok");
    }

    @GetMapping("getOne")
    public ResultUtil<UserEntity> get(@RequestParam Integer id){
        UserEntity user = userService.getById(id);
        return ResultUtil.ok(user);
    }
}
