package com.lwj.entity;

/**
 * @author: linwj
 * @date: 2020-12-23 19:45
 * @description:
 **/
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x, ListNode listNode) {
        next = listNode;
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
