package com.jason.test.demo1;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-16 23:25
 **/
public class BaseImplA extends BaseAbstract {
    @Override
    public void run() {
        System.out.println("running......");
    }

    public static void main(String[] args) {
        BaseAbstract   base=new BaseImplA();
        base.init();
    }
}
