package com.yang.practice.hot100.qa55canjump;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/25
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int target = nums.length;
        int most = 0;
        for (int i = 0; i < target; i++) {
            if (i <= most) {
                most = Math.max(most, i + nums[i]);
                if (most >= target - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
