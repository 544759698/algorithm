package com.yang.practice.hot100.qa287findrepeat;

import java.util.HashSet;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/26
 */
public class FindRepeat {
    // TODO 运行超时，不是最优解
    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
}
