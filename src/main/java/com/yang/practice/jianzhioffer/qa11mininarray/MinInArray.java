package com.yang.practice.jianzhioffer.qa11mininarray;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/15
 */
public class MinInArray {

    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return numbers[low];
    }

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
