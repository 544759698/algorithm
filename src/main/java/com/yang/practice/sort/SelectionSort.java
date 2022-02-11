package com.yang.practice.sort;

/**
 * 选择排序，选出最小的往左边放
 *
 * @Author: yangguojun01
 * @Date: 2022/2/11
 */
public class SelectionSort {

    public void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 8, 1, 2, 6};
        SelectionSort s = new SelectionSort();
        s.selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
