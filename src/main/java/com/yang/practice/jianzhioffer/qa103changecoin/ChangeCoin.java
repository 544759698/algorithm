package com.yang.practice.jianzhioffer.qa103changecoin;

import java.util.Arrays;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/21
 */
public class ChangeCoin {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int result = -1;
            for (int coin : coins) {
                if (i >= coin) {
                    int tmp = memo[i - coin];
                    if (tmp >= 0 && (result == -1 || tmp + 1 < result)) {
                        result = tmp + 1;
                    }
                }
            }
            memo[i] = result;
        }
        return memo[amount];
    }

    public static void main(String[] args) {
        ChangeCoin c = new ChangeCoin();
        int[] coins = {1, 2, 5};
        System.out.println(c.coinChange(coins, 11));
    }

}
