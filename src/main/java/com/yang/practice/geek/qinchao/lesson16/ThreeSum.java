package com.yang.practice.geek.qinchao.lesson16;

import java.util.HashSet;

/**
 * 三数之和
 *
 * @Author: yangguojun01
 * @Date: 2021/12/30
 */
public class ThreeSum {

    public boolean twoSum(int[] nums, int start, int end, int target) {
        if (nums == null || start >= nums.length || end >= nums.length || start < 0 || end < 0 || start > end) {
            return false;
        }
        HashSet<Integer> appared = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (appared.contains(target - nums[i])) {
                return true;
            }
            appared.add(nums[i]);
        }
        return false;
    }

    public boolean threeSum(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        ThreeSum t = new ThreeSum();
        for (int i = 0; i < nums.length; i++) {
            if (t.twoSum(nums, i, nums.length - 1, target - nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 3, 1, 8, 7};
        ThreeSum t = new ThreeSum();
        System.out.println(t.threeSum(nums, 120));
    }

}
