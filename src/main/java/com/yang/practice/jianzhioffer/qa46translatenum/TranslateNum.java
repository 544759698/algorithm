package com.yang.practice.jianzhioffer.qa46translatenum;

/**
 * TODO 需要复习
 *
 * @Author: yangguojun01
 * @Date: 2022/6/18
 */
public class TranslateNum {

    public int translateNum(int num) {
        String strNum = String.valueOf(num);
        int[] dp = new int[strNum.length()];
        dp[0] = 1;
        int tmp = 0;
        if (strNum.length() > 1) {
            tmp = (strNum.charAt(0) - '0') * 10 + (strNum.charAt(1) - '0');
            if (tmp >= 10 && tmp <= 25) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }

        for (int i = 2; i < strNum.length(); i++) {
            dp[i] = dp[i - 1];
            tmp = (strNum.charAt(i - 1) - '0') * 10 + (strNum.charAt(i) - '0');
            if (tmp >= 10 && tmp <= 25) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[strNum.length() - 1];
    }

    public int translateNum1(int num) {
        String strNum = String.valueOf(num);
        int[] dp = new int[strNum.length() + 1];
        // eg:num=12,dp[2]=2
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < strNum.length() + 1; i++) {
            int tmp = (strNum.charAt(i - 2) - '0') * 10 + (strNum.charAt(i - 1) - '0');
            if (tmp >= 10 && tmp <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[strNum.length()];
    }
}
