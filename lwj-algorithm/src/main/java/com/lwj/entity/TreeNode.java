package com.lwj.entity;

/**
 * @author: linwj
 * @date: 2020-12-29 15:13
 * @description:
 **/
public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private int value;

    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
