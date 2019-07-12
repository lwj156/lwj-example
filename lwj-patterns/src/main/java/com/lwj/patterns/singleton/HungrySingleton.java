package com.lwj.patterns.singleton;

/**
 * @author Linwj
 * @date 2019/7/11 16:29
 */
public class HungrySingleton {

    private static final HungrySingleton HUNGRY_SINGLETON=new HungrySingleton();

    public HungrySingleton() {
    }

    public static HungrySingleton getHungrySingleton(){
        return HUNGRY_SINGLETON;
    }

}
