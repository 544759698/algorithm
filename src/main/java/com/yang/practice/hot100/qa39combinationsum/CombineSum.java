package com.yang.practice.hot100.qa39combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/21
 */
public class CombineSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> combine = new ArrayList<>();
        trackback(candidates, target, ret, combine, 0);
        return ret;
    }

    public void trackback(int[] candidates, int remains, List<List<Integer>> ret, List<Integer> combine, int begin) {
        if (begin == candidates.length) {
            return;
        }
        if (remains == 0) {
            ret.add(new ArrayList<>(combine));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (remains >= candidates[i]) {
                combine.add(candidates[i]);
                trackback(candidates, remains - candidates[i], ret, combine, i);
                combine.remove(combine.size() - 1);
            }
        }
    }

}
