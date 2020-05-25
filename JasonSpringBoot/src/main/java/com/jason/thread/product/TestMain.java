package com.jason.thread.product;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-17 23:11
 **/
public class TestMain {
    public static void main(String[] args) {
        Deque<String>  deque=new LinkedList<String>();
        int maxSize=5;
        Thread   productMsg=new ProductMsg(deque,maxSize,"productor");
        Thread   consumeMsg=new ConsumeMsg(deque,"consumer");
        productMsg.start();
        consumeMsg.start();
    }
}
