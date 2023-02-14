package com.yang.practice.geek.qinchao.lesson22;

/**
 * leetcode50 求x的n次方 pow(x,n)
 * https://leetcode.cn/problems/powx-n/description/
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
     * 方法二：非递归写法 TODO 待复习，看注释
     * 参考：https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-fa-by-lelelongwang-2572/
     * @param x
     * @param n
     * @return
     */
    public double myPow2(int x, int n) {
        // 防止n为负数时-n越界
        // NT_MAX是2147483647到-2147483648,-(-2147483648)会超出INT_MAX
        long p = n;
        if (p < 0) {
            x = 1 / x;
            p = -p;
        }
        double ret = 1;
        while (p > 0) {
            if ((p & 1) == 1) {
                // x变化路径为2->4->16... 在此将x升级并乘到结果上，p最小为1，肯定会乘到
                ret = ret * x;
                p = p - 1;
            } else {
                // 此处只需要将x升级，因为p最小为1，ret最后肯定会乘到
                x = x * x;
                p = p / 2;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MyPow s = new MyPow();
        System.out.println(s.myPow(2, -5));
        System.out.println(s.myPow2(2, -5));
    }

}
