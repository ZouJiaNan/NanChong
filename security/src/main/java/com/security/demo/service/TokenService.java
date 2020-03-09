package com.security.demo.service;

import com.security.demo.pojo.User;
import org.springframework.stereotype.Service;

public interface TokenService {
    String getToken(User user);
    boolean checkToken(User user);
}
