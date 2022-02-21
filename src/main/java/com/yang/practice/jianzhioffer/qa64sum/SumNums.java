package com.yang.practice.jianzhioffer.qa64sum;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/21
 */
public class SumNums {
    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums(n - 1);
    }
}
