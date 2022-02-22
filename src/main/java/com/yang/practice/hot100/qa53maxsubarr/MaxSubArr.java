package com.yang.practice.hot100.qa53maxsubarr;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/22
 */
public class MaxSubArr {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // pre + nums[i], nums[i] 比较，(pre + nums[i]) < nums[i] 则断了重新从nums[i]开始
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
