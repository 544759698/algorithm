package com.yang.practice.hot100.qa912quicksort;

import java.util.Arrays;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/7
 */
public class QuickSort {
    public int[] sortArray(int[] nums) {
        partitionSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void partitionSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIdx = getPivotIdx(nums, left, right);
        partitionSort(nums, left, pivotIdx - 1);
        partitionSort(nums, pivotIdx + 1, right);
    }

    public int getPivotIdx(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] nums = {5, 6, 2, 3, 1, 4};
        System.out.println(q.sortArray(nums));
    }

}
