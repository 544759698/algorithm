package com.yang.practice.geek.qinchao.lesson45;

/**
 * leetcode70 爬楼梯，一次只能爬一层或两层，求爬到N层有多少种爬法
 *
 * @Author: yangguojun01
 * @Date: 2022/1/12
 */
public class ClimbStair {

    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n - 1];
    }

}
