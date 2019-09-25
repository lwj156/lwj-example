package com.lwj.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author Linwj
 * @date 2019/9/23 20:27
 */
public class CuratorLockDemo {

    private static final String ZOOKEEPER_URL="192.168.112.129:7181";

    private static final int SESSION_TIMEOUT=5000;

    public static void main(String[] args) {
        CuratorFramework curatorFramework= CuratorFrameworkFactory
                .builder()
                .connectString(ZOOKEEPER_URL)
                .sessionTimeoutMs(SESSION_TIMEOUT)
                .retryPolicy(new ExponentialBackoffRetry(1000,5))
                .build();

        curatorFramework.start();

        //可重入锁
        final InterProcessMutex lock=new InterProcessMutex(curatorFramework,"/lwj/locks");

        //多线程模拟锁竞争
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    lock.acquire();
                    System.out.println(Thread.currentThread().getName() + "获取锁");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        lock.release();
                        System.out.println(Thread.currentThread().getName() + "释放锁");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"ThreadName"+i).start();
        }

    }
}
