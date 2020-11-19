package com.lwj.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Linwj
 * @date 2019/8/13 19:32
 * Condition工具类测试
 */
public class ConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        Thread awaitThread=new Thread(new AwaitThread(condition,lock));
        Thread signalThread=new Thread(new SignalThread(condition,lock));
        awaitThread.start();
        Thread.sleep(1000);
        signalThread.start();
    }


    public static class AwaitThread implements Runnable {
        private Condition condition;
        private Lock lock;

        public AwaitThread(Condition condition, Lock lock) {
            this.condition = condition;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("当前线程" + Thread.currentThread().getName() + "调用await方法");
                condition.await();
                System.out.println("当前线程" + Thread.currentThread().getName() + "停止阻塞");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public static class SignalThread implements Runnable{
        private Condition condition;
        private Lock lock;

        public SignalThread(Condition condition, Lock lock) {
            this.condition = condition;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("当前线程" + Thread.currentThread().getName() + "调用signal方法");
                condition.signal();
                System.out.println("当前线程" + Thread.currentThread().getName() + "执行结束");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
