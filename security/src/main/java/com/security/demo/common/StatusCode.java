package com.security.demo.common;

/*
*@author ZouJiaNan
*@description 系统状态码
*/

public enum  StatusCode {
    SUCCESS(200,"请求成功"),
    NOT_FIND(404,"接口未找到"),
    ERROR(500,"出现异常"),
    ACCESS_DENIED(403,"拒绝访问");

    private Integer code;
    private String message;

    StatusCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
