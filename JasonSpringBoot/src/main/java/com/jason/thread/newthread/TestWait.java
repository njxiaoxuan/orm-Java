package com.jason.thread.newthread;

import com.jason.support.JasonTemplate;
import java.util.*;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-23 15:15
 **/
public class TestWait {

    public final static List<BeanInfo> list =new ArrayList<BeanInfo>();
    public  volatile  static ThreadLocal threadLocal=new ThreadLocal();
    public static Object lock =new Object();
    public  static void main(String[] args) {
        TestWait   testWait=new TestWait();
        Thread thread1=new Thread(()->{
                int local=threadLocal.get()==null?1:Integer.parseInt((String)threadLocal.get());
                //System.out.println(Thread.currentThread().getName()+"---"+local);
                for(int i=local;i<100;i++)
                {
                    synchronized(lock)
                    {

                        if(i%2==1)
                        {
                            try {
                                System.out.println(Thread.currentThread().getName()+i);
                                lock.notify();
                                lock.wait();
                            } catch (InterruptedException e) {
                               continue;
                            }
                        }else
                        {
                            list.add(new BeanInfo(Thread.currentThread().getName(),i));
                        }
                        threadLocal.set(i+"");
                        lock.notifyAll();
                    }

                }
        });

        Thread thread2=new Thread(()->{
            int local=threadLocal.get()==null?1:Integer.parseInt((String)threadLocal.get());
            for(int i=local;i<100;i++)
            {
                synchronized(lock)
                {

                    if(i%2==0)
                    {
                        try {
                            System.out.println(Thread.currentThread().getName()+i);
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            continue;
                        }
                    }else
                    {
                        list.add(new BeanInfo(Thread.currentThread().getName(),i));
                    }
                    threadLocal.set(i+"");
                    lock.notifyAll();

                }
            }
        });
        thread1.start();
        thread1.setName("A");
        thread2.start();
        thread2.setName("B");
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(JasonTemplate.ListToJason(list));
    }
   static class BeanInfo{
        private String threadName;
        private int value;

       public BeanInfo(String threadName, int value) {
           this.threadName = threadName;
           this.value = value;
       }

       public String getThreadName() {
           return threadName;
       }

       public void setThreadName(String threadName) {
           this.threadName = threadName;
       }

       public int getValue() {
           return value;
       }

       public void setValue(int value) {
           this.value = value;
       }
   }
}
