package com.lwj.sword;

import java.util.Stack;

/**
 * @author: linwj
 * @date: 2020-12-30 11:00
 * @description: 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Sword08 {

    class CQueue {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> stackRev = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            if (stackRev.size() == 0) {
                while (stack.size() > 0) {
                    Integer pop = stack.pop();
                    stackRev.add(pop);
                }
            }
            if (stackRev.size() > 0) {
                return stackRev.pop();
            } else {
                return -1;
            }
        }
    }

}
