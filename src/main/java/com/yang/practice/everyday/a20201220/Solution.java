package com.yang.practice.everyday.a20201220;

import java.util.*;

public class Solution {
    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     *
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        // write code here
        if (a == null || a.length == 0) {
            return 1;
        }
        int right = a.length - 1;
        int left = 0;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (a[mid] < v) {
                left = mid + 1;
            } else if (a[mid] > v) {
                right = mid - 1;
            } else {
                int j;
                for (j = mid - 1; j >= 0; j--) {
                    if (a[j] != v) {
                        return j + 2;
                    }
                }
                return 1;
            }
        }
        return a.length + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[] {2,3,4,4,4,7,7,8,10,10,11,12,13,14,15,15,17,18,19,23,24,24,24,24,25,26,26,26,27,27,28,29,29,30,33,36,38,38,40,40,41,43,43,43,44,46,46,47,51,52,52,53,54,56,57,57,57,58,58,61,61,61,62,64,64,66,66,67,67,67,70,72,74,74,74,75,75,78,78,78,79,79,80,83,83,83,83,84,84,86,88,89,89,90,91,91,92,93,93,96};
        Solution solution = new Solution();
        int ret = solution.upper_bound_(100, 1, a);
        System.out.println(ret);
    }
}