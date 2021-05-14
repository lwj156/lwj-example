package com.lwj.test.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: linwj
 * @date: 2021-02-27 16:07
 * @description:
 **/
public class LockSupportDemo {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("aaa");
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("aaa");
        });
        thread1.start();
//        LockSupport.unpark(Thread.currentThread());
//        LockSupport.unpark(Thread.currentThread());
        thread1.interrupt();

        System.out.println("LockSupportDemo");
    }
}
