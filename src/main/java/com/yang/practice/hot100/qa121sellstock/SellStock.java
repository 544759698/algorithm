package com.yang.practice.hot100.qa121sellstock;

/**
 * @Author: yangguojun01
 * @Date: 2022/9/12
 */
public class SellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minLeft = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minLeft) {
                minLeft = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - minLeft);
            }
        }
        return profit;
    }
}
