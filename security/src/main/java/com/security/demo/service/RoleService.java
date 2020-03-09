package com.security.demo.service;

import com.security.demo.pojo.Role;

import java.util.List;

public interface RoleService {
    int count();
    List<Role> findAll(Role role);
    int totalOffindAll();
    void addRole(Role role);
    void delete(Role role);
    void update(Role role);
}
