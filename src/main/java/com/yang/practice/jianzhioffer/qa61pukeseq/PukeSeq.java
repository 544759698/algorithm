package com.yang.practice.jianzhioffer.qa61pukeseq;

import java.util.HashSet;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/14
 */
public class PukeSeq {

    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = 14;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        // TODO 有点秀
        return max - min < 5;
    }

}
