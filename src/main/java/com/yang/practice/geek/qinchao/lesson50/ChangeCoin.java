package com.yang.practice.geek.qinchao.lesson50;

import java.util.Arrays;

/**
 * leetcode322 使用最小硬币数换目标钱数
 *
 * @Author: yangguojun01
 * @Date: 2022/1/14
 */
public class ChangeCoin {

    public int changeCoin(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        // 这里必须赋值
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int result = -1;
            for (int j = 0; j < coins.length; j++) {
                // coins[j]可以用且i-coins[j]有解，最终才能有解，然后判断是不是最小硬币数！！！
                if (i - coins[j] >= 0) {
                    int tmp = memo[i - coins[j]];
                    if (tmp != -1 && (result == -1 || (tmp + 1) < result)) {
                        result = tmp + 1;
                    }
                }
            }
            memo[i] = result;
        }
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        ChangeCoin c = new ChangeCoin();
        System.out.println(c.changeCoin(coins, 5));
    }

}
