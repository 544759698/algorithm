package com.yang.practice.jianzhioffer.qa14cutrope;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/1
 */
public class CutRope {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }
}
