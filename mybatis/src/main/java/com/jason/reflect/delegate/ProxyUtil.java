package com.jason.reflect.delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-14 23:52
 **/
public class ProxyUtil implements InvocationHandler {
    private Base base;
    public ProxyUtil(Base base1) {
        this.base=base1;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------------"+method.getName());
        Object result= method.invoke(base,args);
        return result;
    }

}
