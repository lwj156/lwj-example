package com.lwj.leetcode;

import javax.lang.model.element.NestingKind;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: linwj
 * @date: 2021-01-17 11:49
 * @description: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 **/
public class LC03 {
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> stringSet = new HashSet<>();
        int ans = 0;
        int n = s.length();
        int rk = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                stringSet.remove(s.charAt(i-1));
            }
            while (rk < s.length() && !stringSet.contains(s.charAt(rk))) {
                stringSet.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(rk - i, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        String test="pwwkew";
        int i = lengthOfLongestSubstring(test);
        System.out.println(i);
    }
}
