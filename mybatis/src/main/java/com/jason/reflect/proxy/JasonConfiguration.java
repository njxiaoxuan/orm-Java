package com.jason.reflect.proxy;

import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-14 21:15
 **/
public class JasonConfiguration {
    public  static final Map<String,String> mapperNamespace =new HashMap<String,String>();
    static {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("mybatisConfig");
        Set set=resourceBundle.keySet();
        Iterator iterator=set.iterator();
        String key="";
        while (iterator.hasNext())
        {
            key=(String)iterator.next();
            mapperNamespace.put(key,resourceBundle.getString(key));
        }
    }
    public <T> T getMapper(Class clzz,JasonSqlSession sqlSession) {
        System.out.println("this==="+this);
        System.out.println("this====="+this.getClass().getClassLoader());
           return (T) Proxy.newProxyInstance(
                   this.getClass().getClassLoader(),
                   new Class[]{clzz},
                   new JasonProxy(sqlSession));
    }

    public static void main(String[] args) {
        System.out.println(JasonConfiguration.mapperNamespace.toString());
    }
}
