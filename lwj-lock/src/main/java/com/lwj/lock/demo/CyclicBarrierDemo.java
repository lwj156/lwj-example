package com.lwj.lock.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Linwj
 * @date 2019/8/14 19:30
 */
public class CyclicBarrierDemo{

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("主线程执行");
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "到达屏障");
                    cyclicBarrier.await();
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行中");
            }).start();
        }
    }
}
