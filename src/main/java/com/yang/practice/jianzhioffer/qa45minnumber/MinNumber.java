package com.yang.practice.jianzhioffer.qa45minnumber;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

/**
 * @Author: yangguojun01
 * @Date: 2022/6/18
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrs, (x, y) -> (x + y).compareTo(y + x));
        System.out.println(StringUtils.join(numStrs, ","));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStrs.length; i++) {
            sb.append(numStrs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        MinNumber m = new MinNumber();
        System.out.println(m.minNumber(nums));
    }

}
