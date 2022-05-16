package com.yang.practice.hot100.qa283movezero;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/19
 */
public class MoveZero {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                if (left != right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
                left++;
            }
            right++;
        }
    }
}
