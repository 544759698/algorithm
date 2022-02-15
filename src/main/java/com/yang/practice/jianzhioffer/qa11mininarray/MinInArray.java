package com.yang.practice.jianzhioffer.qa11mininarray;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/15
 */
public class MinInArray {
    public int minArray1(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                min = numbers[i];
            }
        }
        return min;
    }
}
