package com.security.demo.serviceImpl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.security.demo.pojo.User;
import com.security.demo.service.TokenService;
import com.security.demo.util.TokenUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    @Override
    public boolean checkToken(User user) {
        System.out.println("userId:"+user.getId());
          boolean flag=(user.getId()+"").equals(TokenUtil.getTokenUserId(TokenUtil.getToken()));
        System.out.println("判定结果:"+flag);
        return flag;
    }
}
