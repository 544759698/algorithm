package com.yang.practice.geek.qinchao.lesson16;

import java.util.HashSet;

/**
 * leetcode 15 1 三数之和
 *
 * @Author: yangguojun01
 * @Date: 2021/12/30
 */
public class ThreeSum {

    /***
     * 两数之和
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public boolean twoSum(int[] nums, int start, int end, int target) {
        if (nums == null || start >= nums.length || end >= nums.length || start < 0 || end < 0 || start > end) {
            return false;
        }
        HashSet<Integer> appeared = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (appeared.contains(target - nums[i])) {
                return true;
            }
            appeared.add(nums[i]);
        }
        return false;
    }

    /***
     * 三数之和
     * @param nums
     * @param target
     * @return
     */
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
