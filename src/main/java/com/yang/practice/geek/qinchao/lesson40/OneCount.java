package com.yang.practice.geek.qinchao.lesson40;

/**
 * 位1的个数 leetcode 191
 *
 * @Author: yangguojun01
 * @Date: 2022/1/8
 */
public class OneCount {

    public int getOneCount1(int n) {
        int ret = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ret++;
            }
            n = n >> 1;
        }
        return ret;
    }

    public int getOneCount2(int n) {
        int ret = 0;
        while (n != 0) {
            // 打掉最后一位1 eg: 11000 & 10111 = 10000
            n = n & (n - 1);
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        OneCount o = new OneCount();
        System.out.println(o.getOneCount1(7));
        System.out.println(o.getOneCount2(7));
    }

}
