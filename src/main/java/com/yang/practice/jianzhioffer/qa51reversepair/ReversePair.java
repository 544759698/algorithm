package com.yang.practice.jianzhioffer.qa51reversepair;

/**
 * @Author: yangguojun01
 * @Date: 2022/6/22
 */
public class ReversePair {

    public int reversePairs(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    ret++;
                }
            }
        }
        return ret;
    }

}
