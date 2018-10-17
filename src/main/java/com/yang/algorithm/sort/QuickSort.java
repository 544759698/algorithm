package com.yang.algorithm.sort;

/**
 * Created by Administrator on 2018/10/17.
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSortInternal(arr, 0, arr.length - 1);
    }

    public static void quickSortInternal(int[] arr, int p, int r) {
        if (p >= r) return;

        int q = partition(arr, p, r);
        quickSortInternal(arr, p, q - 1);
        quickSortInternal(arr, q + 1, r);
    }

    // 以最后一个元素为基准，获取分区点（找到最后一个元素的位置）
    // 找第K大元素可以用此方法，返回值为K-1时，及找到元素，返回值小于K时，从返回值到结尾处找，大于K时，从开头到返回值处找
    // 这样时间复杂度为O(n)  n+n/2+n/4+n/8+…+1=2n-1
    public static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
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
        arr[i] = arr[r];
        arr[r] = tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 8, 1, 2, 6};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.valueOf(arr[i]) + "->");
        }
    }
}
