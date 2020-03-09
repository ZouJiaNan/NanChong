package com.security.demo.controller;

import com.security.demo.common.Result;
import com.security.demo.common.StatusCode;
import com.security.demo.common.Total;
import com.security.demo.pojo.Department;
import com.security.demo.service.DepartmentService;
import com.security.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/*
 *@author ZouJiaNan
 *@description 部门管理
 */

@RestController
@RequestMapping("/dept")
@Api(tags = "部门管理")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/count")
    @ApiOperation(value="查询总数")
    public Result count(){
        return  new Result<Integer>(StatusCode.SUCCESS.getCode(),departmentService.count());
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查找所有部门")
    public Result findAll(Department department){
        return new Result<List>(StatusCode.SUCCESS.getCode(),departmentService.findAll(department));
    }

    @GetMapping("/findChildAndRoot")
    @ApiOperation(value="通过子部门的ID查找到子部门及其父部门")
    public Result findChildAndRoot(Department department){
        return new Result<List>(StatusCode.SUCCESS.getCode(),departmentService.findChildAndRoot(department));
    }

    @GetMapping("/findRoot")
    @ApiOperation(value="通过ID查找父部门")
    public Result findRoot(Department department){
        return new Result<List>(StatusCode.SUCCESS.getCode(),departmentService.findRoot(department));
    }

    @GetMapping("/findChild")
    @ApiOperation(value="通过ID查找子部门")
    public Result findChild(Department department){
        return new Result<List>(StatusCode.SUCCESS.getCode(),departmentService.findChild(department));
    }

    @PostMapping("/addRoot")
    @ApiOperation(value = "增加父部门")
    public void addRoot(Department department){
        departmentService.addRoot(department);
    }

    @PostMapping("/addChild")
    @ApiOperation(value="增加子部门")
    public void addChild(Department department){
        departmentService.addChild(department);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除部门")
    public void delete(Department department){
        departmentService.delete(department);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改部门")
    public void update(Department department){
        departmentService.update(department);
    }

    @GetMapping("/totalOffindAll")
    @ApiOperation(value="查询查找所有部门总数")
    public Result totalOffindAll() {
        return new Result(StatusCode.SUCCESS.getCode(),new Total(departmentService.totalOffindAll()));
    }

    @GetMapping("/totalOffindChildAndRoot")
    @ApiOperation(value="查询通过子部门的ID查找到子部门及其父部门的总数")
    public Result totalOffindChildAndRoot(Department department) {
        return new Result(StatusCode.SUCCESS.getCode(),new Total(departmentService.totalOffindChildAndRoot(department)));
    }

    @GetMapping("/totalOffindChild")
    @ApiOperation(value="查询通过ID查找子部门的总数")
    public Result totalOffindChild(Department department) {
        return new Result(StatusCode.SUCCESS.getCode(),new Total(departmentService.totalOffindChild(department)));
    }

    @GetMapping("/totalOffindRoot")
    @ApiOperation(value="查询通过ID查找父部门的总数")
    public Result totalOffindRoot(Department department) {
        return new Result(StatusCode.SUCCESS.getCode(),departmentService.totalOffindRoot(department));
    }
}
