package com.yang.practice.sort;

/**
 * 冒泡排序，最大的元素放到最后，相当于往后冒泡
 *
 * @Author: yangguojun01
 * @Date: 2022/2/11
 */
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // 最大的元素放到最后，相当于往后冒泡
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 5, 4};
        BubbleSort b = new BubbleSort();
        b.bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
