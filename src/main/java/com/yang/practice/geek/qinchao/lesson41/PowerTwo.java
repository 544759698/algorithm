package com.yang.practice.geek.qinchao.lesson41;

/**
 * @Author: yangguojun01
 * @Date: 2022/1/9
 */
public class PowerTwo {

    public boolean isPowerOfTwo(int n) {
        // 2的n次方的数转换为二进制只有一个1，打掉就等于0
        return n > 0 && (n & (n - 1)) == 0;
    }

}
