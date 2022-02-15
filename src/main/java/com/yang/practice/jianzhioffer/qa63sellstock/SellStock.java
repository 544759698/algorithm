package com.yang.practice.jianzhioffer.qa63sellstock;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/15
 */
public class SellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int currMinPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            currMinPrice = Math.min(currMinPrice, prices[i]);
            if (prices[i] - currMinPrice > maxProfit) {
                maxProfit = prices[i] - currMinPrice;
            }
        }
        return maxProfit;
    }
}
