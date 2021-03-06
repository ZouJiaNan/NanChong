package com.security.demo.service;

import com.security.demo.pojo.Department;

import java.util.List;

public interface DepartmentService {
    int count();

    List<Department> findAll(Department department);
    int totalOffindAll();

    List<Department> findChildAndRoot(Department department);
    int totalOffindChildAndRoot(Department department);

    List<Department> findChild(Department department);
    int totalOffindChild(Department department);

    List<Department> findRoot(Department department);
    int totalOffindRoot(Department department);

    void addRoot(Department department);
    void addChild(Department department);
    void delete(Department department);
    void update(Department department);
}
