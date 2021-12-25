package com.yang.practice.tiger.qa12coin;

import java.util.Arrays;

/**
 * 换硬币 备忘模型
 *
 * @Author: yangguojun01
 * @Date: 2021/12/22
 */
public class Solution1 {

    public int getMinCoinCount(int[] coins, int target) {
        int[] memo = new int[target + 1];
        // -1:no solution -2:no calculate
        Arrays.fill(memo, -2);
        memo[0] = 0;
        getMemo(memo, coins, target);
        return memo[target];
    }

    private int getMemo(int[] memo, int[] coins, int target) {
        if (memo[target] != -2) {
            return memo[target];
        }
        int result = -1;
        for (int coin : coins) {
            if (target >= coin) {
                int temp = getMemo(memo, coins, target - coin);
                if (temp != -1 && (result == -1 || (temp + 1) < result)) {
                    result = temp + 1;
                }
            }
        }
        memo[target] = result;
        return result;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4};
        int target = 10;
        Solution1 s = new Solution1();
        System.out.println(s.getMinCoinCount(coins, target));
        coins = new int[] {1, 5, 11};
        target = 20;
        System.out.println(s.getMinCoinCount(coins, target));
    }

}
