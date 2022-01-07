package com.yang.practice.geek.qinchao.lesson35;

/**
 * 求平方根
 *
 * @Author: yangguojun01
 * @Date: 2022/1/7
 */
public class Sqrt {

    public double getSqrt(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        double left = 0;
        double right = n;
        while (right - left > 1e-5) {
            double mid = left + (right - left) / 2.0;
            if (mid > (double) n / mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Sqrt s = new Sqrt();
        System.out.println(s.getSqrt(1));
    }
}
