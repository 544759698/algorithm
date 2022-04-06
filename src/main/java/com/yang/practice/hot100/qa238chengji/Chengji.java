package com.yang.practice.hot100.qa238chengji;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/6
 */
public class Chengji {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = left[i] * right[i];
        }
        return ret;
    }
}
