package com.yang.practice.jianzhioffer.qa03repeatnum;

import java.util.HashSet;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/7
 */
public class RepeatNum {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ret = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                ret = nums[i];
                return ret;
            }
        }
        return ret;
    }
}
