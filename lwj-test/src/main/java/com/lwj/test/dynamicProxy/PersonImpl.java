package com.lwj.test.dynamicProxy;

/**
 * @author: linwj
 * @date: 2021-04-10 18:44
 * @description:
 **/
public class PersonImpl implements Person {
    @Override
    public void buy() {
        System.out.println("buy something");
    }
}
