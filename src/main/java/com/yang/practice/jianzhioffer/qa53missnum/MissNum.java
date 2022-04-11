package com.yang.practice.jianzhioffer.qa53missnum;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/11
 */
public class MissNum {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
