package com.yang.practice.hot100.qa494target;

/**
 * @Author: yangguojun01
 * @Date: 2022/8/29
 */
public class Target {

    public int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        traceback(nums, target, 0, 0);
        return count;
    }

    public void traceback(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            traceback(nums, target, idx + 1, sum + nums[idx]);
            traceback(nums, target, idx + 1, sum - nums[idx]);
        }
    }

}
