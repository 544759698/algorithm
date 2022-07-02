package com.yang.practice.jianzhioffer.qa49uglynumber;

/**
 * TODO 需要练习 1
 * @Author: yangguojun01
 * @Date: 2022/6/20
 */
public class UglyNumber {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (num2 == dp[i]) {
                p2++;
            }
            if (num3 == dp[i]) {
                p3++;
            }
            if (num5 == dp[i]) {
                p5++;
            }
        }
        return dp[n - 1];
    }

}
