package com.yang.practice.sort;

/**
 * 快排
 *
 * @Author: yangguojun01
 * @Date: 2022/2/11
 */
public class QuickSort {

    public void quickSort(int[] arr) {
        quickSortInternal(arr, 0, arr.length - 1);
    }

    public void quickSortInternal(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int end_pos = partition(arr, start, end);
        quickSortInternal(arr, start, end_pos - 1);
        quickSortInternal(arr, end_pos + 1, end);
    }

    /***
     * 1.以最后一个元素为基准，获取分区点（找到最后一个元素的位置）
     * 2.两个指针，一个指向当前第一个比基准值大的数，另一个遍历数组寻找比基准值小的数，找到后交换
     * 3.最后第一个指针数与基准值交换
     * 4.返回第一个指针，此值为分区点
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        // 当前第一个比pivot大的数，i=start时除外
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                if (i != j) {
                    swap(arr, i, j);
                }
                i++;
            }
        }
        // 这里不能漏
        swap(arr, i, end);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 8, 1, 2, 6};
        QuickSort q = new QuickSort();
        q.quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
