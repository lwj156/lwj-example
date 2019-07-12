package com.lwj.patterns;

import com.lwj.patterns.singleton.HungrySingleton;

/**
 * @author Linwj
 * @date 2019/7/11 16:31
 */
public class SingletonTest {

    public static void main(String[] args) {
        HungrySingleton hungrySingleton=new HungrySingleton();
        HungrySingleton hungrySingleton1=HungrySingleton.getHungrySingleton();
        System.out.println(hungrySingleton);
        System.out.println(hungrySingleton1);
    }
}
