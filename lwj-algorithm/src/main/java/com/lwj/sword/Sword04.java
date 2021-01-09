package com.lwj.sword;

/**
 * @author: linwj
 * @date: 2020-12-16 19:08
 * @description:
 **/
public class Sword04 {

    public static void main(String[] args) {

    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (j >= 0 && i <= matrix.length - 1) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
