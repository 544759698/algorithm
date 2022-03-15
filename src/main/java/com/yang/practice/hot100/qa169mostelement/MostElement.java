package com.yang.practice.hot100.qa169mostelement;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/15
 */
public class MostElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer ret = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ret = nums[i];
            }
            count += ret == nums[i] ? 1 : -1;
        }
        return ret;
    }
}
