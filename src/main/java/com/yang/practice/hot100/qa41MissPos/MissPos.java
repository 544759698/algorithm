package com.yang.practice.hot100.qa41MissPos;

import java.util.HashSet;

/**
 * TODO 非最优解
 *
 * @Author: yangguojun01
 * @Date: 2022/3/10
 */
public class MissPos {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> appeared = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            appeared.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!appeared.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }
}
