package com.lwj.leetcode;

/**
 * @author: linwj
 * @date: 2021-01-15 14:14
 * @description:
 **/
public class LC53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            sum = Math.max(sum, num);
        }
        return sum;
    }
}
