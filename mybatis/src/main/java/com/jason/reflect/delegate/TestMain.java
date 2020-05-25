package com.jason.reflect.delegate;

import com.jason.reflect.Student;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-14 23:55
 **/
public class TestMain {
    public static void main(String[] args) {

        Base  dynamic=new SessionFactory();
        Base  base  =TestMain.getProxy(dynamic);
        base.query("helloword");
        base.add("helloword");



    }
    public static Base  getProxy(Base base)
    {
        return(Base) Proxy.newProxyInstance(
                base.getClass().getClassLoader(),
                base.getClass().getInterfaces(),
                new ProxyUtil(base));
    }
}
