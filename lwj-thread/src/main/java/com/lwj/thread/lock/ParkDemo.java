package com.lwj.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Linwj
 * @date 2019/8/14 11:09
 */
public class ParkDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            LockSupport.park();
            System.out.println("线程1获取许可证");
        });
        thread.start();
        LockSupport.unpark(thread);
        System.out.println("主线程执行完毕");
    }
}
