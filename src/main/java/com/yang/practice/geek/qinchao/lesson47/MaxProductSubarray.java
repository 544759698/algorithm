package com.yang.practice.geek.qinchao.lesson47;

import java.util.Arrays;

/**
 * leetcode 152 最大乘积子数组
 *
 * @Author: yangguojun01
 * @Date: 2022/1/12
 */
public class MaxProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maxF = Arrays.copyOf(nums, nums.length);
        int[] minF = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ret = maxF[0];
        for (int j = 1; j < maxF.length; j++) {
            ret = Math.max(ret, maxF[j]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        MaxProductSubarray m = new MaxProductSubarray();
        System.out.println(m.maxProduct(nums));
    }

}
