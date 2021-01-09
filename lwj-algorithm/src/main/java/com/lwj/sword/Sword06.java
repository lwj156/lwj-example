package com.lwj.sword;

import com.lwj.entity.ListNode;

import javax.management.ListenerNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: linwj
 * @date: 2020-12-23 19:44
 * @description: https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 **/
public class Sword06 {

    public int[] reversePrint(ListNode head) {

        List<Integer> integerList = new ArrayList<>();

        while (head != null) {
            integerList.add(head.getVal());
            head = head.getNext();
        }
        int[] result = new int[integerList.size()];
        for (int i = integerList.size() - 1; i >= 0; i--) {
            result[i] = integerList.get(i);
        }
        return result;

    }

    public int[] reversePrintStack(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.getNext();
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            ListNode pop = stack.pop();
            result[i] = pop.getVal();
        }
        return result;

    }

}
