package com.security.demo.util;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.ArrayList;
import java.util.List;

public class UrlUtil {
    private static List<String> urls;

    static{
        urls=new ArrayList<>();
        urls.add("role");
        urls.add("/dept");
        urls.add("/user");
    }

    public static boolean isIllegal(String url){
        if("/".equals(url)){
            return true;
        }
        return false;
    }

    public static String spiltUrl(String url){
        System.out.println(url);

        //有些url为"/"
        //首先判断字符串是否合法,即是否为"/"
        if(!isIllegal(url))
        {
            //分割url
            String[] result= url.split("/");
            //swagger加载动态资源的时候，url没有前面的IP地址
            //即分割字符串以后只有1-2位
            //处理此种情况
            if(result.length<2){
                return result[0];
            }
            //处理业务请求
            return result[1];
        }
        //如果为"/"的请求，直接返回原字符串
        return url;
    }
    public static boolean isIntercept(String url){

        return urls.contains(spiltUrl(url));
    }
}
