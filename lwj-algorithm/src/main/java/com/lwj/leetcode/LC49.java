package com.lwj.leetcode;

import javax.print.DocFlavor;
import java.util.*;

/**
 * @author: linwj
 * @date: 2021-01-17 18:24
 * @description:
 **/
public class LC49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> strings = map.get(new String(chars));
            if (strings==null){
                strings=new ArrayList<>();
            }
            strings.add(str);
            map.put(new String(chars),strings);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] test=new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(test);
        System.out.println(lists);
    }
}
