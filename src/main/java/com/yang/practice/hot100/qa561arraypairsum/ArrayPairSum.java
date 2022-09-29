package com.yang.practice.hot100.qa561arraypairsum;

import java.util.Arrays;

/**
 * @Author: yangguojun01
 * @Date: 2022/9/29
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            ret += nums[i];
        }
        return ret;
    }
}
