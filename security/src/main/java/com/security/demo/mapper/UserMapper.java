package com.security.demo.mapper;

import com.security.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int count();
    List<User> findAll(User user);
    int totalOffindAll();
    List<User> findUser(User user);
    int totalOffindUser(User user);
    void addUser(User user);
    void updateUser(User user);
    void updateRole(User user);
    void deleteUser(User user);
}
