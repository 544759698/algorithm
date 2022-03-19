package com.yang.practice.hot100.qa448lostnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/19
 */
public class LostNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] != idx + 1 && nums[nums[idx] - 1] != nums[idx]) {
                int tmp = nums[nums[idx] - 1];
                nums[nums[idx] - 1] = nums[idx];
                nums[idx] = tmp;
            } else {
                idx++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
