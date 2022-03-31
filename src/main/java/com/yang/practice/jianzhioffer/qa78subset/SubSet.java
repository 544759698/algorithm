package com.yang.practice.jianzhioffer.qa78subset;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/31
 */
public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = ret.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newList = new ArrayList<>(ret.get(j));
                newList.add(nums[i]);
                ret.add(newList);
            }
        }
        return ret;
    }
}
