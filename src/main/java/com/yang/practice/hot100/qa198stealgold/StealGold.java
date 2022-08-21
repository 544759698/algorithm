package com.yang.practice.hot100.qa198stealgold;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/5
 */
public class StealGold {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (dp.length <= 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}
