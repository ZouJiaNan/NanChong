package com.security.demo.util;

import com.auth0.jwt.JWT;
import com.security.demo.pojo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class TokenUtil {
    public static String getTokenUserId(String token) {
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    public static boolean checkToken(){
        //获取id的时候一并进行非空判断
        String id=getRequest().getParameter("id")==null ? "" : getRequest().getParameter("id") ;
        //验证token中的id是否为正确的id
        return id.equals(getTokenUserId(getToken()));
    }

    public static String getToken(){
        String token=getRequest().getHeader("token");
        return token==null?"":token;
    }
}
