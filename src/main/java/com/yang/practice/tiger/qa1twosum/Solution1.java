package com.yang.practice.tiger.qa1twosum;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/two-sum/
 *
 * @Author: yangguojun01
 * @Date: 2021/12/13
 */
public class Solution1 {

    public boolean findTarget(int[] nums, int target) {
        HashSet<Integer> appeared = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (appeared.contains(target - nums[i])) {
                return true;
            }
            appeared.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        System.out.println(s1.findTarget(new int[] {2, 4, 5, 7, 10}, 12));
        System.out.println(s1.findTarget(new int[] {2, 4, 5, 7, 10}, 9));
        System.out.println(s1.findTarget(new int[] {2, 4, 5, 7, 10}, 8));
    }

}
