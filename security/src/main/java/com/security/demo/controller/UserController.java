package com.security.demo.controller;

import com.security.demo.common.Result;
import com.security.demo.common.StatusCode;
import com.security.demo.common.Total;
import com.security.demo.pojo.User;
import com.security.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/count")
    @ApiOperation(value="查询总数")
    public Result count(){
        return  new Result<Integer>(StatusCode.SUCCESS.getCode(),userService.count());
    }

    @GetMapping("/findAll")
    @ApiOperation(value="查找所有用户")
    public Result findAll(User user){
        return  new Result<List>(StatusCode.SUCCESS.getCode(),userService.findAll(user));
    }

    @GetMapping("/totalOffindAll")
    @ApiOperation(value="统计查找所有用户的总数")
    public Result totalOffindAll() {
        return new Result(StatusCode.SUCCESS.getCode(),new Total(userService.totalOffindAll()));
    }

    @GetMapping("/totalOffindUser")
    @ApiOperation(value="统计通过ID或者用户名查找用户的总数")
    public Result totalOffindUser(User user) {
        return new Result(StatusCode.SUCCESS.getCode(),new Total(userService.totalOffindUser(user)));
    }

    @GetMapping("/findUser")
    @ApiOperation(value="通过ID或者用户名查找用户")
    public Result findUser(User user){
        return new Result<List>(StatusCode.SUCCESS.getCode(), userService.findUser(user));
    }

    @PostMapping("/addUser")
    @ApiOperation(value="添加用户")
    public void addUser(User user){
        userService.addUser(user);
    }

    @PostMapping("/updateUser")
    @ApiOperation(value="修改用户信息")
    public void updateUser(User user){
        //修改权限
        userService.updateRole(user);
        //修改用户信息
        userService.updateUser(user);
    }

    @PostMapping("/deleteUser")
    @ApiOperation(value="删除用户")
    public void deleteUser(User user){
        userService.deleteUser(user);
    }
}
