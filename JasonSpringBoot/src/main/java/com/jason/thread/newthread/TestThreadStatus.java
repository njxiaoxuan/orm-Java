package com.jason.thread.newthread;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-21 22:10
 **/
public class TestThreadStatus {

    private static  Object lock=new Object();

    public synchronized  static void update()
    {

            System.out.println("-----------------");
    }
    public static void main(String[] args) {
            new Thread("lockThread1"){
                @Override
                public void run() {
                    TestThreadStatus.update();
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        new Thread("lockThread2"){
            @Override
            public void run() {
                TestThreadStatus.update();
                try {
                    sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println("-------------------------");

    }
}
