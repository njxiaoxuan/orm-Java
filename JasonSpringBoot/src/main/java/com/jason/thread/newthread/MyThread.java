package com.jason.thread.newthread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-19 18:51
 **/
public class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {

        return "------";
    }
}
