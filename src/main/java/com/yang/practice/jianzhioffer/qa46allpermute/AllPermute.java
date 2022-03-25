package com.yang.practice.jianzhioffer.qa46allpermute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/25
 */
public class AllPermute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ans.add(nums[i]);
        }
        backTrack(ret, ans, n, 0);
        return ret;
    }

    public void backTrack(List<List<Integer>> ret, List<Integer> ans, int n, int idx) {
        if (idx == n - 1) {
            ret.add(new ArrayList<>(ans));
        }
        for (int i = idx; i < n; i++) {
            Collections.swap(ans, idx, i);
            backTrack(ret, ans, n, idx + 1);
            Collections.swap(ans, idx, i);
        }
    }

}
