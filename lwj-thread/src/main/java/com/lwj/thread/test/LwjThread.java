package com.lwj.thread.test;

import java.util.concurrent.Executors;

/**
 * @author: linwj
 * @date: 2020-11-16 22:43
 * @description:
 **/
public class LwjThread extends Thread {

    public static void main(String[] args) {
        new LwjThread().start();
        new Thread(new LwjThread()).start();
    }

    @Override
    public void run() {
        super.run();
    }
}
