package com.jason.test.demo1;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-16 23:23
 **/
public abstract class BaseAbstract {
    public void init()
    {
        System.out.println("initConfig");
        run();
    }
    public abstract  void run();
}
