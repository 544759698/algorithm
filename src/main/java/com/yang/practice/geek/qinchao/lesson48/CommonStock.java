package com.yang.practice.geek.qinchao.lesson48;

/**
 * leetcode 121 122 123 309 188 714 买卖股票系列
 *
 * @Author: yangguojun01
 * @Date: 2022/1/13
 */
public class CommonStock {

    /***
     * 买卖一次算交易一次
     * @param prices
     * @param k 交易次数
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        // 买卖一次算交易一次，大于n/2相当于没有交易次数限制
        k = Math.min(k, n / 2);
        /*dp定义：dp[i][j][k]代表 第i天交易了k次时的最大利润，其中j代表当天是否持有股票，0不持有，1持有*/
        int[][][] maxProfit = new int[n][2][k + 1];
        for (int kTmp = 0; kTmp <= k; kTmp++) {
            // 第1天买入 - 卖出循环 K 次之后不再买入，所以初始值为 0
            maxProfit[0][0][kTmp] = 0;
            // 第1天买入 - 卖出循环 K 次之后又买入，所以初始值为 -prices[0]
            maxProfit[0][1][kTmp] = -prices[0];
        }
        /*状态方程：
        dp[i][0][k]，当天不持有股票时，看前一天的股票持有情况
        dp[i][1][k]，当天持有股票时，看前一天的股票持有情况*/
        for (int i = 1; i < n; i++) {
            for (int kTmp = 0; kTmp <= k; kTmp++) {
                // kTmp==0时并不是取两数的最大值，而是等于0
                // TODO:为什么kTmp不能从1开始？？？
                maxProfit[i][0][kTmp] =
                        kTmp == 0 ? 0 : Math.max(maxProfit[i - 1][0][kTmp], maxProfit[i - 1][1][kTmp - 1] + prices[i]);
                maxProfit[i][1][kTmp] = Math.max(maxProfit[i - 1][0][kTmp] - prices[i], maxProfit[i - 1][1][kTmp]);
            }
            //            for (int kTmp = 1; kTmp <= k; kTmp++) {
            //                maxProfit[i][0][kTmp] = Math.max(maxProfit[i - 1][0][kTmp], maxProfit[i - 1][1][kTmp -
            //                1] + prices[i]);
            //                maxProfit[i][1][kTmp] = Math.max(maxProfit[i - 1][0][kTmp] - prices[i], maxProfit[i -
            //                1][1][kTmp]);
            //            }
        }
        return maxProfit[n - 1][0][k];
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        CommonStock s = new CommonStock();
        System.out.println(s.maxProfit(2, prices));
    }

}
