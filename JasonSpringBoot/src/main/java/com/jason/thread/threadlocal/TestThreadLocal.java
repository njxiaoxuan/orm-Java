package com.jason.thread.threadlocal;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-24 19:42
 **/
public class TestThreadLocal implements Runnable {
    public static ThreadLocal local1=new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return 0;
        }
    };
    public static ThreadLocal local2=new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return "hello threadLocal";
        }
    };

    @Override
    public void run() {
            local1.set(2);
            local2.set(Thread.currentThread().getName()+"----"+local2.get());

        System.out.println(Thread.currentThread().getName()+"--threadlocal="+local1.get());
        System.out.println(Thread.currentThread().getName()+"--threadlocal="+local2.get());
    }

    public static void main(String[] args) {
        Runnable   local1=new TestThreadLocal();
        Runnable   local2=new TestThreadLocal();
        Thread thread1=new Thread(local1,"Thread A");
        Thread thread2=new Thread(local1,"Thread B");
        thread1.start();
        thread2.start();

    }
}
