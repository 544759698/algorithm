package com.yang.practice.hot100.qa322coinchange;

import java.util.Arrays;

/**
 * @Author: yangguojun01
 * @Date: 2022/9/18
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int result = -1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    if (dp[i - coins[j]] >= 0 && (result == -1 || dp[i - coins[j]] + 1 < result)) {
                        result = dp[i - coins[j]] + 1;
                    }
                }
            }
            dp[i] = result;
        }
        return dp[amount];
    }
}
