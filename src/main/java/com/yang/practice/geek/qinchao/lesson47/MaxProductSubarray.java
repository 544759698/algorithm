package com.yang.practice.geek.qinchao.lesson47;

/**
 * leetcode152 最大乘积子数组
 *
 * @Author: yangguojun01
 * @Date: 2022/1/12
 */
public class MaxProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 存储到第i个数的最大值
        int[] maxF = new int[nums.length];
        // 存储到第i个数的最小值，因为存在负负得正的情况
        int[] minF = new int[nums.length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        int ret = maxF[0];
        for (int i = 1; i < nums.length; i++) {
            // maxF[i - 1] * nums[i], minF[i - 1] * nums[i], nums[i] 三个数比较
            // nums[i]当之前结果为负，nums[i]>=0时，最大值为nums[i]
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            ret = Math.max(ret, maxF[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, -1, 6};
        MaxProductSubarray m = new MaxProductSubarray();
        System.out.println(m.maxProduct(nums));
    }

}
