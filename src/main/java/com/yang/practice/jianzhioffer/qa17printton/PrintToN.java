package com.yang.practice.jianzhioffer.qa17printton;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/18
 */
public class PrintToN {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] retArr = new int[max - 1];
        for (int i = 1; i < max; i++) {
            retArr[i - 1] = i;
        }
        return retArr;
    }
}
