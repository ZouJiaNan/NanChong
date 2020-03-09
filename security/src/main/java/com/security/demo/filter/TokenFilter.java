package com.security.demo.filter;

import com.security.demo.util.TokenUtil;
import com.security.demo.util.UrlUtil;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //将请求类型强转为http类型，方便对header中的数据做判断
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        //获取请求的url
        String Url=httpRequest.getRequestURI();

        //拦截需要拦截的Url,主要目的是以实现拦截业务方法而放行非业务方法（主要是swagger的请求）
        if(UrlUtil.isIntercept(Url)){
            //判断是否未携带token
            if("".equals(TokenUtil.getToken())) {
                httpResponse.sendRedirect("token/lock");
            }
            //判断token是否合法（是否正确？是否过期？）
            if(!TokenUtil.checkToken()){
                httpResponse.sendRedirect("token/illegal");
            }
            chain.doFilter(httpRequest,httpResponse);
        }else {
            chain.doFilter(httpRequest,httpResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
