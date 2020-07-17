package com.yang.practice.sort;

/**
 * 插入排序
 * Created by Administrator on 2018/10/15.
 */
public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 8, 1, 2, 6};
        arr = insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.valueOf(arr[i]) + "->");
        }
    }
}
