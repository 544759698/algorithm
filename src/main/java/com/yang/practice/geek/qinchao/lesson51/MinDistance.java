package com.yang.practice.geek.qinchao.lesson51;

/**
 * leetcode 72 两个单词的最小距离，可以删除、插入、替换
 * TODO 待复习，记住！！！
 *
 * @Author: yangguojun01
 * @Date: 2022/1/15
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 有一个字符串为空串
        if (m * n == 0) {
            return m + n;
        }
        // DP数组，word1的前i个字符和word2的前j个字符的编辑距离
        int[][] dp = new int[m + 1][n + 1];
        // 边界状态初始化，一个子串到空字符串的编辑距离等于子串的长度
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        // 计算所有DP值 本质不同的操作实际上只有三种：
        // 1.在word1子串中插入一个字符；2.在word2子串中插入一个字符；3.修改word1或word2子串的一个字符
        // 三者取最小
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[m][n];
    }

}
