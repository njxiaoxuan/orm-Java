package com.jason.thread.product;
import static java.lang.Thread.sleep;
import java.util.Deque;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-17 23:05
 **/
public class ConsumeMsg extends   Thread {
    private Deque<String> deque;

    public ConsumeMsg(Deque<String> deque,String threadName) {
        super(threadName);
        this.deque = deque;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (deque) {
                while (deque.isEmpty()) {
                    System.out.println("队列为空，通知生产者，抓紧生产消息");
                    try {
                        deque.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费一个消息：" + deque.remove());
                deque.notifyAll();

            }
        }
    }
}
