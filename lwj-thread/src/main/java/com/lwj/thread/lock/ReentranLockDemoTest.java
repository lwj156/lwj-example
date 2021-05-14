package com.lwj.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: linwj
 * @date: 2021-03-03 15:51
 * @description:
 **/
public class ReentranLockDemoTest {

    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        // 注意lock加锁要在try..catch结构体外面
        // 原因是如果lock加锁失败被异常捕获后，在执行unlock操作
        // 而当前线程并未获得锁，会抛出IllegalMonitorStateException
        lock.lock();
        try {
            // 业务逻辑
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
