package com.jason.thread.deadthread;

import java.lang.Thread.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-23 23:50
 **/
public class TestMain {
    public static void main(String[] args) {
        Thread thread1=new Thread(new Thread1(),"thread1");
        Thread thread2=new Thread(new Thread2(),"thread2");
        thread1.start();
        thread2.start();
    }

}

class Thread1 implements Runnable
{
    @Override
    public void run() {
        try {
            if(Locks.lock1.tryLock())
            {
                System.out.println("Thread2 lock resource2");
                Thread.sleep(2000);
                if (Locks.lock2.tryLock()) {
                    System.out.println("Thread2 lock resource1");
                }
                System.out.println("Thread2 release resource1");
            }
            System.out.println("Thread2 release resource2");

            if(Locks.lock1.tryLock()){
                System.out.println("Thread1 lock resource1");
                Thread.sleep(2000);
                if(Locks.lock2.tryLock()){
                    System.out.println("Thread1 lock resource2");
                }
                System.out.println("Thread1 release resource2");
            }
            System.out.println("Thread1 release resource1");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
class Thread2 implements Runnable
{
    @Override
    public void run() {
        try {
            if(Locks.lock2.tryLock())
            {
                    System.out.println("Thread2 lock resource2");
                    Thread.sleep(2000);
                    if (Locks.lock1.tryLock()) {
                        System.out.println("Thread2 lock resource1");
                    }
                    System.out.println("Thread2 release resource1");
            }
            System.out.println("Thread2 release resource2");


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
class Locks{
//    static Object lock1=new Object();
//    static Object lock2=new Object();

    static Lock lock1=new ReentrantLock();
    static Lock lock2=new ReentrantLock();
}
