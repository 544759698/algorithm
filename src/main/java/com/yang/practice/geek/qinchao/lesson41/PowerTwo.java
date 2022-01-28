package com.yang.practice.geek.qinchao.lesson41;

/**
 * leetcode231 2的幂 给你一个整数 n，请你判断该整数是否是 2 的幂次方
 * TODO 记住就好
 *
 * @Author: yangguojun01
 * @Date: 2022/1/9
 */
public class PowerTwo {

    public boolean isPowerOfTwo(int n) {
        // 2的n次方的数转换为二进制只有一个1，打掉就等于0
        return n > 0 && (n & (n - 1)) == 0;
        // eg: 10000000 & 01111111 == 0
    }

}
