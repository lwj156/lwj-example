package com.lwj.leetcode;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: linwj
 * @date: 2021-01-16 19:36
 * @description: https://leetcode-cn.com/problems/two-sum/
 **/
public class LC01 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
