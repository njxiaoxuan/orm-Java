package com.jason.reflect.proxy;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-14 21:56
 **/
public class TestProxy {

    public static void main(String[] args) {
           JasonSqlSession  sqlSession=new JasonSqlSession(new JasonConfiguration());
           StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
           studentMapper.queryStudentById("1");
    }
}
