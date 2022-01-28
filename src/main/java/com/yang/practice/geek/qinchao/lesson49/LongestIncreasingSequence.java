package com.yang.practice.geek.qinchao.lesson49;

/**
 * leetcode300 最长增长子序列长度（子序列可以不连续）
 *
 * @Author: yangguojun01
 * @Date: 2022/1/14
 */
public class LongestIncreasingSequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // lisLength[i] => 到第i个元素子序列长度，注意：第i个元素必选
        // 在计算lisLength[i]之前，我们已经计算出lisLength[0…i−1]的值
        int[] lisLength = new int[nums.length];
        lisLength[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            // TODO 必须赋上初始值1
            lisLength[i] = 1;
            // 该层循环查找前i-1个子序列中的最大值
            for (int j = 0; j < i; j++) {
                // nums[i]>nums[j]时，nums[i]可以加入子序列，则长度+1
                if (nums[i] > nums[j]) {
                    // TODO 转换方程！！！
                    lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
                }
            }
            max = Math.max(max, lisLength[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18, 21}; // 2,3,7,18,21
        LongestIncreasingSequence l = new LongestIncreasingSequence();
        System.out.println(l.lengthOfLIS(nums));
    }

}


