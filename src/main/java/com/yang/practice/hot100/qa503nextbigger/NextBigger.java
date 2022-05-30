package com.yang.practice.hot100.qa503nextbigger;

import java.util.Arrays;

/**
 * @Author: yangguojun01
 * @Date: 2022/5/30
 */
public class NextBigger {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new int[] {-1};
        }
        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);
        for (int i = 0; i < ret.length; i++) {
            int idx = i + 1;
            while (idx != i) {
                if (idx == ret.length) {
                    idx = 0;
                }
                if (nums[idx] > nums[i]) {
                    ret[i] = nums[idx];
                    break;
                }
                idx++;
            }
        }
        return ret;
    }

}
