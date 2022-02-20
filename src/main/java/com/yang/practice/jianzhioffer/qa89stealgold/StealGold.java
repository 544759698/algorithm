package com.yang.practice.jianzhioffer.qa89stealgold;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/20
 */
public class StealGold {
    public int rob(int[] nums) {
        int[] maxMoney = new int[nums.length];
        maxMoney[0] = nums[0];
        if (nums.length == 1) {
            return maxMoney[0];
        }
        maxMoney[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
        }
        return maxMoney[maxMoney.length - 1];
    }
}
