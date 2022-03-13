package com.yang.practice.geek.qinchao.lesson16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * leetcode 15 1 三数之和
 * TODO 待复习，三数之和返回不重复的三元组
 *
 * @Author: yangguojun01
 * @Date: 2021/12/30
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 3) {
            return ret;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 注释中的方法对于重复值上来就跳过，会错过前两个值相同但第三个值不同的解，如 [-1,-1,2]
            //            if ((i + 1) < nums.length && nums[i] == nums[i + 1]) {
            //                continue;
            //            }
            for (int j = i + 1; j < nums.length; j++) {
                //                if ((j + 1) < nums.length && nums[j] == nums[j + 1]) {
                //                    continue;
                //                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int third = nums.length - 1;
                while (third > j) {
                    if (nums[i] + nums[j] + nums[third] == 0) {
                        List<Integer> retItem = new ArrayList<>();
                        retItem.add(nums[i]);
                        retItem.add(nums[j]);
                        retItem.add(nums[third]);
                        ret.add(retItem);
                        break;
                    }
                    if (nums[i] + nums[j] + nums[third] < 0) {
                        break;
                    }
                    third--;
                }
            }
        }
        return ret;
    }

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
    public boolean checkThreeSum(int[] nums, int target) {
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
        System.out.println(t.checkThreeSum(nums, 120));
    }

}
