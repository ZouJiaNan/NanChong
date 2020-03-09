package com.security.demo.common;

import lombok.Data;

import java.security.PrivateKey;

/*
 *@author ZouJiaNan
 *@description 封装返回值的实体类
 */
@Data
public class Result<T> {
    //状态码
    private int statusCode;
    //数据域
    private T data;
    //消息域
    private String message;

    public Result(int statusCode,T data){
        this.data=data;
        this.statusCode=statusCode;
    }

    public Result(int statusCode,String message){
        this.data=data;
        this.message=message;
    }
}
