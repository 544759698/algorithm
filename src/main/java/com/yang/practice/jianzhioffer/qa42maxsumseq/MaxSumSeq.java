package com.yang.practice.jianzhioffer.qa42maxsumseq;

/**
 * TODO 需要练习
 * @Author: yangguojun01
 * @Date: 2022/2/15
 */
public class MaxSumSeq {
    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        int max = memo[0];
        for (int i = 1; i < nums.length; i++) {
            // 分成两段 memo[i - 1] + nums[i] 和 nums[i]
            memo[i] = Math.max(memo[i - 1] + nums[i], nums[i]);
            max = Math.max(max, memo[i]);
        }
        return max;
    }

    public int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1};
        MaxSumSeq m = new MaxSumSeq();
        System.out.println(m.maxSubArray(nums));
    }

}
