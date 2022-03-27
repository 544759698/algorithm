package com.yang.practice.jianzhioffer.qa39combinesum;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/27
 */
public class CombineSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(candidates, 0, ret, ans, target);
        return ret;
    }

    public void dfs(int[] candidates, int idx, List<List<Integer>> ret, List<Integer> ans, int target) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        dfs(candidates, idx + 1, ret, ans, target);
        if (target - candidates[idx] >= 0) {
            ans.add(candidates[idx]);
            dfs(candidates, idx, ret, ans, target - candidates[idx]);
            ans.remove(ans.size() - 1);
        }
    }

}
