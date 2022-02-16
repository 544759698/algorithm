package com.yang.practice.jianzhioffer.qa15onecount;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/16
 */
public class OneCount {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n = n & (n - 1);
            ret++;
        }
        return ret;
    }
}
