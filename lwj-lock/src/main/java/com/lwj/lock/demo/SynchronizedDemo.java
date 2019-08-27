package com.lwj.lock.demo;

/**
 * @author Linwj
 * @date 2019/8/8 11:32
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo=new SynchronizedDemo();
        new Thread(()->{
            synchronized (synchronizedDemo){
                try {
                    synchronizedDemo.wait();
                    System.out.println("线程被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (synchronizedDemo){

            synchronizedDemo.notify();
        }

        println();
    }

    public static void println(){
        System.out.println("方法1");
    }
}
