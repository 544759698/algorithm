package com.yang.practice.problem;

import java.util.HashMap;

/**
 * 数组：[2,7,11,13]
 * 求加和为18的两个元素下标
 */
public class TwoNumbersInArray {
    public static String getTwoNumbersIndex(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                ret.append("[" + String.valueOf(map.get(target - arr[i]).intValue()));
                ret.append(",");
                ret.append(String.valueOf(i) + "]");

                return ret.toString();
            }
            map.put(arr[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 13};
        System.out.println(getTwoNumbersIndex(input, 18));
    }
}
