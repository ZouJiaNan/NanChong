package com.security.demo.controller;

import com.security.demo.common.Result;
import com.security.demo.common.StatusCode;
import com.security.demo.common.Total;
import com.security.demo.pojo.Role;
import com.security.demo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
 *@author ZouJiaNan
 *@description 权限管理
 */
@RestController
@RequestMapping("/role")
@Api(tags = "权限管理")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/count")
    @ApiOperation(value="查询总数")
    public Result count(){
        return  new Result<Integer>(StatusCode.SUCCESS.getCode(),roleService.count());
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查找所有权限")
    public Result findAll(Role role){
        return new Result<List>(StatusCode.SUCCESS.getCode(),roleService.findAll(role));
    }

    @GetMapping("/totalOffindAll")
    @ApiOperation(value = "统计查找所有权限的总数")
    public Result totalOffindAll(Role role){
        return new Result(StatusCode.SUCCESS.getCode(),new Total(roleService.totalOffindAll()));
    }

    @PostMapping("/add")
    @ApiOperation(value="添加权限")
    public void addRole(Role role){
        roleService.addRole(role);
    }

    @PostMapping("/delete")
    @ApiOperation(value="删除权限")
    public void delete(Role role){
        roleService.delete(role);
    }

    @PostMapping("/update")
    @ApiOperation(value="修改权限")
    public void update(Role role){
        roleService.update(role);
    }
}
