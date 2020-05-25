package com.jason.thread.newthread;

import static java.lang.Thread.sleep;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-23 14:29
 **/
public class TestJoin {
    static int i=0;
    public static void main(String[] args) {
           Thread thread=new Thread(()->{
                 while(!Thread.currentThread().isInterrupted())
                 {
                     try {
                         sleep(100);
                         System.out.println(i++);
                     } catch (InterruptedException e) {
                         System.out.println("捕获到中断");
                         break;
                     }

                 }
           });
        thread.start();
        try {
            //sleep(8000);
            //thread.interrupt();
            thread.join();

            System.out.println("main over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
