package com.jason.reflect.proxy;

import com.jason.reflect.Student;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-14 21:24
 **/
public class JasonExecutor {

    public <T> T query(String sql, Object param) {
        System.out.println(sql);
        System.out.println();
        return (T) new Student();
    }
}
