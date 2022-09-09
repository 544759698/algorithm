package com.yang.practice.hot100.qa70climbstair;

/**
 * @Author: yangguojun01
 * @Date: 2022/9/9
 */
public class ClimbStair {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }
}
