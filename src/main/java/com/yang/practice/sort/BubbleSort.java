package com.yang.practice.sort;

/**
 * 冒泡排序
 *
 * @Author: yangguojun01
 * @Date: 2022/2/11
 */
public class BubbleSort {

    public int[] bubbleSort(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }
        for (int i = 0; i < a.length; i++) {
            // 最大的元素放到最后，相当于往后冒泡
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 6, 5, 4};
        BubbleSort b = new BubbleSort();
        a = b.bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
