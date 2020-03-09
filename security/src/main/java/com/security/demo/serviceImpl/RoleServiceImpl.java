package com.security.demo.serviceImpl;

import com.security.demo.mapper.RoleMapper;
import com.security.demo.pojo.Role;
import com.security.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper mapper;

    @Override
    public int count() {
        return mapper.count();
    }

    @Override
    public List<Role> findAll(Role role) {
        return mapper.findAll(role);
    }

    @Override
    public int totalOffindAll() { return mapper.totalOffindAll();}

    @Override
    public void addRole(Role role) {
        mapper.addRole(role);
    }

    @Override
    public void delete(Role role) {
        mapper.delete(role);
    }

    @Override
    public void update(Role role) {
        mapper.update(role);
    }
}
