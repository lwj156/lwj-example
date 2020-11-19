package com.lwj.thread.test;

import java.util.concurrent.TimeUnit;

/**
 * @author: linwj
 * @date: 2020-11-17 20:48
 * @description:
 **/
public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread thread=new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread");
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }

    //锁的作用域 对象锁
    private synchronized void sync1 (){

    }

    //对象锁
    private void sync3(){
        synchronized (this){

        }
    }

    //类锁
    private synchronized static void sync2(){

    }

    //类锁
    private void sync4(){
        synchronized (Integer.class){

        }
    }
}
