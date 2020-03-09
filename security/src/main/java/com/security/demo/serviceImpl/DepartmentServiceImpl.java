package com.security.demo.serviceImpl;

import com.security.demo.mapper.DepartmentMapper;
import com.security.demo.pojo.Department;
import com.security.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper mapper;

    @Override
    public int count() {
        return mapper.count();
    }

    @Override
    public List<Department> findAll(Department department) {
        return mapper.findAll(department);
    }

    @Override
    public void addRoot(Department department) {
        mapper.addRoot(department);
    }

    @Override
    public void addChild(Department department) {
        mapper.addChild(department);
    }

    @Override
    public void delete(Department department) {
        mapper.delete(department);
    }


    @Override
    public void update(Department department) {
        mapper.update(department);
    }

    @Override
    public List<Department> findChildAndRoot(Department department) {
        return mapper.findChildAndRoot(department);
    }

    @Override
    public List<Department> findChild(Department department) {
        return mapper.findChild(department);
    }

    @Override
    public List<Department> findRoot(Department department) {
        return mapper.findRoot(department);
    }

    @Override
    public int totalOffindAll() {
        return mapper.totalOffindAll();
    }

    @Override
    public int totalOffindChildAndRoot(Department department) {
        return mapper.totalOffindChildAndRoot(department);
    }

    @Override
    public int totalOffindChild(Department department) {
        return mapper.totalOffindChild(department);
    }

    @Override
    public int totalOffindRoot(Department department) {
        return mapper.totalOffindRoot(department);
    }
}
