package com.security.demo.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Department {
    private String id;
    private String create_by;
    private String create_time;
    private Integer del_flag;
    private String update_by;
    private String update_time;
    private String parent_id;
    private BigDecimal sort_order;
    private String status;
    private String title;
    private Boolean is_parent;

    private Integer pageNum;
    private Integer pageSize;

    public String getId(){
        return this.id;
    }

    //父节点的子节点
    private List<Department> childs;
}
