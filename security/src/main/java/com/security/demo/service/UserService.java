package com.security.demo.service;

import com.security.demo.pojo.User;

import java.util.List;

public interface UserService {
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
