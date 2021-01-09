package com.lwj.sword;

import com.lwj.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linwj
 * @date: 2020-12-29 15:14
 * @description:
 **/
public class Sword07 {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return reConstructBinaryTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public static TreeNode reConstructBinaryTree(int[] preorder, int startPreIndex, int endPreIndex,
                                                 int[] inorder, int startInIndex, int endInIndex) {

        if (startPreIndex > endPreIndex) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[startPreIndex]);
        //root节点在中序遍历中的位置
        Integer rootInIndex = map.get(preorder[startPreIndex]);

        treeNode.setLeft(reConstructBinaryTree(preorder, startPreIndex + 1, startPreIndex + rootInIndex - startInIndex,
                inorder, startInIndex, rootInIndex - 1));
        treeNode.setRight(reConstructBinaryTree(preorder, startPreIndex + rootInIndex + 1 - startInIndex, endPreIndex,
                inorder, rootInIndex + 1, endInIndex));
        return treeNode;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] b = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(buildTree(a, b));
    }
}
