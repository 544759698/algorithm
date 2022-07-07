package com.yang.practice.jianzhioffer.qa56singlenumber;

/**
 * @Author: yangguojun01
 * @Date: 2022/7/7
 */
public class SingleNumber {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret = ret ^ n;
        }
        int lowOne = 1;
        while ((ret & lowOne) == 0) {
            lowOne = lowOne << 1;
        }
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((lowOne & n) == 0) {
                a = a ^ n;
            } else {
                b = b ^ n;
            }
        }
        return new int[] {a, b};
    }
}
