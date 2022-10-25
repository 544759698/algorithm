package com.yang.practice.tiger.qa12coin;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/
 * 换硬币 演绎模型
 *
 * @Author: yangguojun01
 * @Date: 2021/12/22
 */
public class Solution2 {

    public int getMinCoinCount(int[] coins, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        for (int sum = 1; sum <= target; sum++) {
            int result = -1;
            for (int coin : coins) {
                if (sum - coin >= 0) {
                    int temp = memo[sum - coin];
                    if (temp != -1 && (result == -1 || (temp + 1) < result)) {
                        result = temp + 1;
                    }
                }
            }
            memo[sum] = result;
        }
        return memo[target];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4};
        int target = 10;
        Solution2 s = new Solution2();
        System.out.println(s.getMinCoinCount(coins, target));
        coins = new int[] {1, 5, 11};
        target = 20;
        System.out.println(s.getMinCoinCount(coins, target));
    }
}
