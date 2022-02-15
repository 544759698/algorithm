package com.yang.practice.jianzhioffer.qa10fibo;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/13
 */
public class Fibo {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = (first + second) % 1000000007;
            first = second;
            second = tmp;
        }
        return second;
    }

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = (first + second) % 1000000007;
            first = second;
            second = tmp;
        }
        return second;
    }

}
