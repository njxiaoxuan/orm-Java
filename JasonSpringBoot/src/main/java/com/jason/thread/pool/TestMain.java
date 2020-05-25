package com.jason.thread.pool;

import com.alibaba.druid.support.json.JSONUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-19 22:28
 **/
public class TestMain {
    public static void main(String[] args) {
        ExecutorService  pool= Executors.newFixedThreadPool(10);
        pool.execute(new Thread("test1"){
            @Override
            public void run() {
                System.out.println("---------------");
            }
        });
        ScheduledExecutorService pool2=Executors.newScheduledThreadPool(10);
        try {
            pool2.awaitTermination(1, TimeUnit.SECONDS);
            pool2.schedule(new Thread("test"){
                @Override
                public void run() {
                    System.out.println("pool2---------------");
                }
            },3,TimeUnit.SECONDS);
            pool2.scheduleAtFixedRate(new Thread("test4"){
                @Override
                public void run() {
                    System.out.println("scheduleAtFixedRate---------------");
                }
            },1,3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
