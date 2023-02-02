package com.yang.practice.tiger.qa4firstone;

/**
 * 二分法
 * https://leetcode.cn/problems/binary-search/
 *
 * @Author: yangguojun01
 * @Date: 2021/12/23
 */
public class Solution {

    public int firstOne(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1};
        Solution s = new Solution();
        System.out.println(s.firstOne(nums));
    }

}
