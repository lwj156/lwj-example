package com.lwj.lock.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author Linwj
 * @date 2019/8/14 13:33
 * CountDownLatch模拟高并发
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行中");
            }).start();
        }
        countDownLatch.countDown();
        System.out.println("主线程执行完毕");
    }
}
