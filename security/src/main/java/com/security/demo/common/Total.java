package com.security.demo.common;

import lombok.Data;

@Data
public class Total {
    private int total;
    public Total(int total){
        this.total=total;
    }
}
