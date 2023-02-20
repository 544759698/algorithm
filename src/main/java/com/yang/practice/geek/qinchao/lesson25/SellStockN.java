package com.yang.practice.geek.qinchao.lesson25;

/**
 * leetcode122 买卖股票，最简单的题，给一组价格，不限制买卖次数
 * leetcode121 买卖股票，给一组价格，买卖一次
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 *
 * @Author: yangguojun01
 * @Date: 2022/1/4
 */
public class SellStockN {

    // 122
    public int getMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }

    // 121
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        SellStockN s = new SellStockN();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(s.getMaxProfit(prices));
        System.out.println(s.maxProfit(prices));
    }

}
