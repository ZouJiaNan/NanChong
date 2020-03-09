package com.security.demo.controller;

import com.security.demo.common.Result;
import com.security.demo.common.StatusCode;
import com.security.demo.common.Token;
import com.security.demo.pojo.User;
import com.security.demo.service.TokenService;
import com.sun.org.apache.xpath.internal.operations.String;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/token")
@Api(tags = "token管理")
public class TokenController {
    @Autowired
    TokenService tokenService;

    @GetMapping("/get")
    @ApiOperation(value="获取Token")
    public Result getToken(User user){
        return new Result(StatusCode.SUCCESS.getCode(),new Token(tokenService.getToken(user)));
    }

    @RequestMapping("/lock")
    @ApiOperation(value = "检测token是否存在")
    public Result lock(User user)throws Exception{
        return new Result(StatusCode.ACCESS_DENIED.getCode(),"非法请求：未检测到token");
    }

    @RequestMapping("/illegal")
    @ApiOperation(value = "验证token是否合法")
    public Result illegal(){
        return new Result(StatusCode.ACCESS_DENIED.getCode(),"非法请求：使用过期或者错误的token");
    }
}
