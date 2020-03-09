package com.security.demo.serviceImpl;

import com.security.demo.mapper.UserMapper;
import com.security.demo.pojo.User;
import com.security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public int count() {
        return mapper.count();
    }

    @Override
    public List<User> findAll(User user) {
        return mapper.findAll(user);
    }

    @Override
    public List<User> findUser(User user) {
        return mapper.findUser(user);
    }

    @Override
    public void addUser(User user) {
        mapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        mapper.updateUser(user);
    }

    @Override
    public void updateRole(User user) {
        mapper.updateRole(user);
    }

    @Override
    public void deleteUser(User user) {
        mapper.deleteUser(user);
    }

    @Override
    public int totalOffindAll() {
        return mapper.totalOffindAll();
    }

    @Override
    public int totalOffindUser(User user) {
        return mapper.totalOffindUser(user);
    }
}
