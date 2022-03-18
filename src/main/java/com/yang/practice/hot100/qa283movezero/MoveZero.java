package com.yang.practice.hot100.qa283movezero;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/19
 */
public class MoveZero {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length) {
                    if (nums[j] != 0) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                    j++;
                }
                if (j >= nums.length) {
                    return;
                }
            }
            i++;
        }
    }
}
