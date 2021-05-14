package com.lwj.leetcode;

import java.util.*;

/**
 * @author: linwj
 * @date: 2021-01-19 18:36
 * @description:
 **/
public class LC347 {
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }
        String a=null;
        List<Map.Entry<Integer,Integer>> mapList=new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        mapList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int [] result =new int[k];
        for (int i = 0; i < k; i++) {
            result[i]=mapList.get(i).getKey();
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums=new int[]{4,1,-1,2,-1,2,3};
        int[] ints = topKFrequent(nums, 2);
        System.out.println(ints);
    }
}
