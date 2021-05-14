package com.lwj.algorithm;

import com.sun.tools.internal.xjc.generator.util.WhitespaceNormalizer;

import java.util.Arrays;
import java.util.Date;

/**
 * @author: linwj
 * @date: 2021-03-29 13:54
 * @description:
 **/
public class BaseSort {

    public static void main(String[] args) {
        int[] data = {1, 5, 4, 7, 3, 4};
//        maoPaoSort(data);
//        selectionSort(data);
        quickSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }

    /**
     * todo 冒泡排序：每次把最大数交换到末尾位置
     *
     * @param data
     * @return
     */
    public static int[] maoPaoSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            boolean flag = true;
            for (int j = 0; j < data.length - i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
                flag = false;
            }
            // 若内层循环没有执行，说明数据已经是顺序的了
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(data));
        return data;
    }

    /**
     * todo 选择排序：从第i个数开始，对比i+1的数字，最小的交换到i的位置
     *
     * @param data
     * @return
     */
    public static int[] selectionSort(int[] data) {
        int min = 0;
        for (int i = 0; i < data.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[min] > data[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(data, i, min);
            }
        }
        System.out.println(Arrays.toString(data));
        return data;
    }

    /**
     * todo 插入排序，在前面有序数字里面找到可以插入的位置
     * 参考扑克牌思想
     * @param data
     * @return
     */
    public static int[] insertSort(int[] data) {
        int j, temp;
        for (int i = 1; i < data.length; i++) {
            temp = data[i];
            for (j = i; j >= 1 && data[j] > temp; j--) {
                data[j] = data[j - 1];
            }
            data[j] = temp;
        }
        System.out.println(Arrays.toString(data));
        return data;
    }

    /**
     * 快速排序
     * @param data
     * @param low
     * @param high
     */
    public static void quickSort(int[] data, int low, int high) {
        if (low<high){
            int middle = getMiddle(data, low, high);
            quickSort(data,0,middle-1);
            quickSort(data,middle+1,high);
        }
    }

    private static int getMiddle(int[] data,int low, int high) {
        int temp=data[low];
        while (low < high){
            while (low < high && temp <= data[high]){
                high--;
            }
            data[low]=data[high];
            while(low < high && data[low] <= temp) {
                low++;
            }
            data[high]=data[low];
        }
        data[low]=temp;
        return low;
    }

    /**
     * 数组交换操作
     *
     * @param data
     * @param i
     * @param j
     */
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
