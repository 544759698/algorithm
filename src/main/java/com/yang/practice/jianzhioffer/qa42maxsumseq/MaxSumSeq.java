package com.yang.practice.jianzhioffer.qa42maxsumseq;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/15
 */
public class MaxSumSeq {
    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        int max = memo[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i] = Integer.MIN_VALUE;
            if (memo[i - 1] > 0 && nums[i] <= 0) {
                memo[i] = memo[i - 1];
                continue;
            }
            for (int j = 0; j <= i; j++) {
                int jSum = sum(nums, j, i);
                memo[i] = Math.max(jSum, memo[i]);
            }
        }

        for (int i = 1; i < memo.length; i++) {
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
