package com.lwj.leetcode;

/**
 * @author: linwj
 * @date: 2021-03-26 15:16
 * @description:
 **/
public class QuickOrder {
    public static void quickSort(int[]arr,int low,int high){
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            quickSort(arr, low, middle - 1);//递归左边
            quickSort(arr, middle + 1, high);//递归右边
        }
    }
    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];
        while (low < high) {
            while (low < high && list[high] >= tmp) {//大于关键字的在右边
                high--;
            }
            list[low] = list[high];//小于关键字则交换至左边
            while (low < high && list[low] <= tmp) {//小于关键字的在左边
                low++;
            }
            list[high] = list[low];//大于关键字则交换至左边
        }
        list[low] = tmp;
        return low;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,5,4,3,6,7,5};
        quickSort(arr,0,6);
        System.out.println(arr.toString());
    }
}
