package com.yang.practice.jianzhioffer.qa46translatenum;

/**
 * TODO 需要复习 1
 *
 * @Author: yangguojun01
 * @Date: 2022/6/18
 */
public class TranslateNum {

    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length()];
        dp[0] = 1;
        for (int i = 1; i < numStr.length(); i++) {
            int tmp = (numStr.charAt(i - 1) - '0') * 10 + (numStr.charAt(i) - '0');
            if (tmp > 9 && tmp < 26) {
                if (i > 1) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[1] = 2;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[numStr.length() - 1];
    }

}
