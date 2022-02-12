package com.yang.practice.hot100.qa136oncenum;

import java.util.HashSet;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/12
 */
public class OnceNum {
    public int singleNumber(int[] nums) {
        HashSet<Integer> appeared = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!appeared.add(nums[i])) {
                appeared.remove(nums[i]);
            }
        }
        return (int)appeared.toArray()[0];
    }
}
