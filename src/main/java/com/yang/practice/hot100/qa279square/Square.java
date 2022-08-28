package com.yang.practice.hot100.qa279square;

/**
 * @Author: yangguojun01
 * @Date: 2022/8/28
 */
public class Square {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minCount = Math.min(minCount, dp[i - j * j]);
            }
            dp[i] = minCount + 1;
        }
        return dp[n];
    }
}
