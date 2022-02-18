package com.yang.practice.jianzhioffer.qa16mypow;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/19
 */
public class MyPow {
    public double myPow(double x, int n) {
        long p = n;
        if (x == 0) {
            return 0;
        }
        if (p == 0 || x == 1) {
            return 1;
        }
        if (p < 0) {
            p = -p;
            x = 1 / x;
        }
        double ret = 1;
        while (p > 0) {
            if ((p & 1) == 0) {
                x = x * x;
                p = p >> 1;
            } else {
                ret = ret * x;
                p = p - 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MyPow m = new MyPow();
        System.out.println(m.myPow(2, 5));
    }

}
