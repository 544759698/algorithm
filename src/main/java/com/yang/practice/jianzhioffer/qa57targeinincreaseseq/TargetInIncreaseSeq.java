package com.yang.practice.jianzhioffer.qa57targeinincreaseseq;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/12
 */
public class TargetInIncreaseSeq {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                ret[0] = nums[i];
                ret[1] = nums[j];
                break;
            }
        }
        return ret;
    }
}
