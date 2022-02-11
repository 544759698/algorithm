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
     * 2.找第K大元素可以用此方法，返回值为K-1时，及找到元素，返回值小于K时，从返回值到结尾处找，大于K时，从开头到返回值处找
     * 3.这样时间复杂度为O(n)  n+n/2+n/4+n/8+…+1=2n-1
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                if (i != j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                i++;
            }
        }

        int tmp = arr[i];
        arr[i] = arr[end];
        arr[end] = tmp;

        return i;
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
