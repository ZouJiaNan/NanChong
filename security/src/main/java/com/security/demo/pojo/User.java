package com.security.demo.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String id;
    private String create_by;
    private String create_time;
    private String update_by;
    private String update_time;
    private String address;
    private String avatar;
    private String description;
    private String email;
    private String  mobile;
    private String nick_name;
    private String password;
    private String sex;
    private Integer status;
    private Integer type;
    private String username;
    private Integer del_flag;
    private String department_id;
    private String street;
    private String pass_strength;

    private Integer pageNum;
    private Integer pageSize;
    //权限
    private List<Role> role;
    //部门
    private List<Department> department;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
