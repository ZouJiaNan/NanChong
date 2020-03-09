package com.security.demo.pojo;

import lombok.Data;

@Data
public class Role {
    private String id;
    private String create_by;
    private String create_time;
    private String update_by;
    private String update_time;
    private String name;
    private Integer del_flag;
    private String default_role;
    private String description;
    private Integer data_type;

    private Integer pageNum;
    private Integer pageSize;
}
