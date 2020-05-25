package com.jason.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-14 21:32
 **/
public class JasonProxy implements InvocationHandler {
    private JasonSqlSession sqlSession;

    public JasonProxy(JasonSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String sid=method.getDeclaringClass().getName()+"."+method.getName();
        return sqlSession.selectOne(sid,args[0]);
    }
}
