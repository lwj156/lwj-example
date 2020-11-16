package com.lwj.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {

        Thread a=new Thread(()->{
            System.out.println("aaa");
            LockSupport.park();
            System.out.println("bbb");
        });
        a.start();
//        a.interrupt();
    }
}
