package com.yang.practice.jianzhioffer.qa57continuoussequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/25
 */
public class ContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 1; i <= target / 2 + 1; i++) {
            int j = i;
            int sum = i;
            while (sum < target) {
                j++;
                sum += j;
            }
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int p = i; p <= j; p++) {
                    list.add(p);
                }
                ret.add(list);
            }
        }
        int[][] ans = new int[ret.size()][];
        for (int i = 0; i < ret.size(); i++) {
            int[] arr = new int[ret.get(i).size()];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = ret.get(i).get(j);
            }
            ans[i] = arr;
        }
        return ans;
    }

    public static void main(String[] args) {
        ContinuousSequence c = new ContinuousSequence();
        c.findContinuousSequence(9);
    }

}
