package com.yang.practice.hot100.qa198stealgold;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/5
 */
public class StealGold {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        memo[1] = nums[0];
        int max = memo[1];
        for (int i = 1; i < nums.length; i++) {
            memo[i + 1] = Math.max(memo[i - 1] + nums[i], memo[i]);
            max = Math.max(max, memo[i + 1]);
        }
        return max;
    }
}
