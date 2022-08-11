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
            // 跳过相同值
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

    // 未跳过相同值的版本
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> ans = new ArrayList<>();
        dfs(candidates, target, ret, ans, 0);
        return ret;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ret, List<Integer> ans, int begin) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            ans.add(candidates[i]);
            dfs(candidates, target - candidates[i], ret, ans, i);
            ans.remove(ans.size() - 1);
        }
    }

}
