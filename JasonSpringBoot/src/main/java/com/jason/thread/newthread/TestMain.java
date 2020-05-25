package com.jason.thread.newthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-19 18:50
 **/
public class TestMain {
    public static void main(String[] args) {

        Callable<String>  callable=new MyThread();
        FutureTask<String>  futureTask=new FutureTask<String>(callable);
        new Thread(futureTask).start();


        try {
            String  result=futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Lamboa
        FutureTask<String> futureTask1=new FutureTask<String>(
                (Callable<String>)()->{
                    return "helloWord!";
                }
        );
        try {
            new Thread(futureTask1).start();
            System.out.println("33333333333333"+futureTask1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
