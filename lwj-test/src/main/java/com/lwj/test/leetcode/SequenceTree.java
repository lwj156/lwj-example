package com.lwj.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序排列
 */
public class SequenceTree {

    //递归处理
    public List<Integer> SequenceTree(TreeNode root){
        List<Integer> res=new ArrayList<>();
        helperV2(root,res);
        return res;
    }

    public void helper(TreeNode treeNode,List<Integer> res){
        if (treeNode.left!=null){
            helper(treeNode.left,res);
        }
        res.add(treeNode.val);
        if (treeNode.right!=null){
            helper(treeNode.right,res);
        }
    }

    public void helperV2(TreeNode treeNode,List<Integer> res){
        if (treeNode==null){
            return;
        }
        res.add(treeNode.val);
        helperV2(treeNode.left,res);
        helperV2(treeNode.right,res);
    }


    public void helperLeft(TreeNode treeNode,List<Integer> res){
        if (treeNode.left!=null){
            res.add(treeNode.val);
            helper(treeNode.left,res);
        }
        if (treeNode.right!=null){
            res.add(treeNode.right.val);
            helper(treeNode.right,res);
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
