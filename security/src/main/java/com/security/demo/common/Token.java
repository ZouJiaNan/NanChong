package com.security.demo.common;

import lombok.Data;

@Data
public class Token {
    private String token;
    public Token(String token){
        this.token=token;
    }
}
