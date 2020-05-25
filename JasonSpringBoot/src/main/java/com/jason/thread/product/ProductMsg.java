package com.jason.thread.product;

import java.util.Deque;

import static java.lang.Thread.sleep;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-17 22:59
 **/
public class ProductMsg  extends   Thread{
    private Deque<String>  deque;
    private int maxSize;

    public ProductMsg(Deque<String> deque, int maxSize,String threadName) {
        super(threadName);
        this.deque = deque;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {
               while(true){
                   synchronized (deque) {
                       while(deque.size()==maxSize)
                       {
                           try
                           {
                               System.out.println("deque  is full wait");
                               deque.wait();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                       System.out.println("生产消息："+deque.add("message"));
                       deque.notifyAll();
                       try {
                           sleep(3000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
           }
    }
}
