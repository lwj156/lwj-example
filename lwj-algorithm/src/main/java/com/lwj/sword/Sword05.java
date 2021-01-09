package com.lwj.sword;


/**
 * @author: linwj
 * @date: 2020-12-23 19:23
 * @description: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 **/
public class Sword05 {


    public String replaceSpace(String s) {
        char[] array=new char[s.length()*3];
        int size=0;
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if (c==' '){
                array[size++]='%';
                array[size++]='2';
                array[size++]='0';
            }else {
                array[size++]=c;
            }
        }
        String result=new String(array,0,size);
        return result;

    }

    public static void main(String[] args) {


    }
}
