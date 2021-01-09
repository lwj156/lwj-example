package com.lwj.test.count;

/**
 * @author: linwj
 * @date: 2020-12-13 14:19
 * @description:
 **/
public class BitTest {
    public static void main(String[] args) {
        int num = 100;
        //乘2
        System.out.println(num << 1);
        //除2
        System.out.println(num >> 1);
        //除2+1
        System.out.println(num >> 1 | 1);
    }
}
