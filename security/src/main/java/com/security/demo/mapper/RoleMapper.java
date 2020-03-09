package com.security.demo.mapper;

import com.security.demo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    int count();
    List<Role> findAll(Role role);
    int totalOffindAll();
    void addRole(Role role);
    void delete(Role role);
    void update(Role role);
}
