package com.yang.practice.hot100.qa338bitcount;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/19
 */
public class BitCount {
    public int[] countBits(int n) {
        int[] ret = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ret[i] = getOneCount(i);
        }
        return ret;
    }

    private int getOneCount(int n) {
        int ret = 0;
        while (n > 0) {
            n = n & (n - 1);
            ret++;
        }
        return ret;
    }
}
