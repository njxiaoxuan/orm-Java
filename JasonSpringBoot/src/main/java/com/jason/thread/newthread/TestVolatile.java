package com.jason.thread.newthread;

import static java.lang.Thread.sleep;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-21 20:44
 **/
public class TestVolatile {
    private  static volatile boolean isflag=false;

    public static void main(String[] args) {
        Thread thread=new Thread("testVolatile"){
            @Override
            public void run() {
                  int i=0;
                  while(!isflag)
                  {
                      //System.out.println("test....");
                      i++;
                      try {
                          sleep(10);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                System.out.println(this.getName()+"----"+i);
            }
        };
        thread.start();
        try {
            sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isflag=true;

    }
}
