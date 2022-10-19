package com.yang.practice.tiger.qa10fibo;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @Author: yangguojun01
 * @Date: 2021/12/12
 */
public class Solution {

    int[] memo;

    public Solution() {
        memo = new int[1000];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
    }

    public int f1(int n) {
        if (n < 0) {
            return -1;
        }
        if (memo[n] == -1) {
            memo[n] = f1(n - 1) + f1(n - 2);
        }
        return memo[n];
    }

    public int f2(int n) {
        if (n < 0) {
            return -1;
        }
        for (int i = 2; i < n; i++) {
            memo[n] = memo[n - 1] + memo[n - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.f1(11));
        System.out.println(s1.f2(11));
    }

}
