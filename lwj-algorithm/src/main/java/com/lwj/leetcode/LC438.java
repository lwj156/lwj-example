package com.lwj.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: linwj
 * @date: 2021-01-26 19:56
 * @description: https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 **/
public class LC438 {
    public static List<Integer> findAnagrams(String s, String p) {
        char[] chars = s.toCharArray();
        List<Integer> list=new ArrayList<>();
        char[] val=p.toCharArray();
        Arrays.sort(val);
        if (p.length()>s.length()){
            return list;
        }
        for (int i = 0; i < chars.length-p.length()+1; i++) {
            String result="";
            char[] charsNew=new char[p.length()];
            for (int j = 0; j < p.length(); j++) {
                charsNew[j]=chars[i+j];
            }
            Arrays.sort(charsNew);
            if (new String(charsNew).equals(new String(val))){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("abab", "ab");
        System.out.println(anagrams);
    }
}
