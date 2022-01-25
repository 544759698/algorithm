package com.yang.practice.geek.qinchao.lesson22;

/**
 * leetcode50 求x的n次方 pow(x,n)
 *
 * @Author: yangguojun01
 * @Date: 2022/1/3
 */
public class MyPow {

    /***
     * 方法一：递归写法
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        // 防止n为负数时-n越界
        // NT_MAX是2147483647到-2147483648,-(-2147483648)会超出INT_MAX
        long ln = n;
        if (ln < 0) {
            return 1 / myPowInner(x, -ln);
        }
        return myPowInner(x, ln);
    }

    public double myPowInner(double x, long ln) {
        if (ln == 0) {
            return 1;
        }
        if ((ln & 1) == 1) {
            return x * myPowInner(x, ln - 1);
        } else {
            return myPowInner(x * x, ln / 2);
        }
    }

    /***
     * 方法二：非递归写法 TODO 不理解
     * 参考：https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-fa-by-lelelongwang-2572/
     * @param x
     * @param n
     * @return
     */
    public double myPow2(int x, int n) {
        long p = n;
        p = Math.abs(p);
        double temp = x;
        double result = 1;
        while (p > 0) {
            //如果是奇数
            if ((p & 1) == 1) {
                result = result * temp;
            }
            temp = temp * temp;
            //每次指数变为原来的二倍
            p = p / 2;
        }
        return n > 0 ? result : 1.0 / result;
    }

    public static void main(String[] args) {
        MyPow s = new MyPow();
        System.out.println(s.myPow(2, -5));
        System.out.println(s.myPow2(2, -5));
    }

}
