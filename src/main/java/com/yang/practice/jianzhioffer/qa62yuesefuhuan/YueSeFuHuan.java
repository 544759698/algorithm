package com.yang.practice.jianzhioffer.qa62yuesefuhuan;

/**
 * @Author: yangguojun01
 * @Date: 2022/7/16
 */
public class YueSeFuHuan {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % n;
        }
        return x;
    }
}
