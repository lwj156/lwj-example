package com.lwj.leetcode;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.CheckedOutputStream;

/**
 * @author: linwj
 * @date: 2021-01-30 10:05
 * @description: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 **/
public class LC102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int count=queue.size();
            List<Integer> list=new ArrayList<>();
            while (count>0){
                TreeNode treeNode = queue.poll();
                if (treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.offer(treeNode.right);
                }
                count--;
                list.add(treeNode.val);
            }
            result.add(list);
        }
        return result;
    }
}
