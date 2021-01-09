package com.lwj.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linwj
 * @date: 2020-12-14 19:49
 * @description: https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 **/
public class Sword03 {

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] array={2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(array);
        System.out.println("重复的数字是"+repeatNumber);
    }

    public static int findRepeatNumber(int[] nums) {
        //首先创建map容器
        //往map对象中添加数据，key为值，value为次数。遍历过程中，若map中已经存在，则为重复数字
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.get(num)==null){
                map.put(num,1);
            }else {
                return num;
            }
        }
        return -1;
    }

}
