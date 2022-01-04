package com.yang.practice.geek.qinchao.lesson22;

/**
 * 求x的n次方 pow(x,n)
 *
 * @Author: yangguojun01
 * @Date: 2022/1/3
 */
public class MyPow {

    /***
     * 递归写法
     * @param x
     * @param n
     * @return
     */
    public double myPow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2);
    }

    /***
     * 非递归写法
     * @param x
     * @param n
     * @return
     */
    public double myPow2(int x, int n) {
        if (n == 0) {
            return 1;
        }
        double dx = x;
        if (n < 0) {
            n = -n;
            dx = 1 / dx;
        }
        double pow = 1;
        // 通过n/2，判断x要乘以多少次它自身
        while (n > 0) {
            // if n&1==1
            if (n % 2 == 1) {
                pow = dx * pow;
            }
            dx = dx * dx;
            n = n / 2;
        }
        return pow;
    }

    public static void main(String[] args) {
        MyPow s = new MyPow();
        System.out.println(s.myPow(2, -5));
        System.out.println(s.myPow2(2, -5));
    }

}
