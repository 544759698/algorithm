package com.yang.practice.hot100.qa983mincostticket;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/24
 */
public class MinCostTicket {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        dp[0] = 0;
        int d = 0;
        for (int i = 1; i < dp.length; i++) {
            if (days[d] == i) {
                int c1 = dp[i - 1] + costs[0];
                int c2 = (i > 7 ? dp[i - 7] : dp[0]) + costs[1];
                int c3 = (i > 30 ? dp[i - 30] : dp[0]) + costs[2];
                dp[i] = Math.min(Math.min(c1, c2), c3);
                d++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
