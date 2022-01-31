package com.yang.practice.geek.qinchao.lesson32;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode51 N皇后问题
 * TODO 待复习
 *
 * @Author: yangguojun01
 * @Date: 2022/1/7
 */
public class NQueens {

    public List<List<String>> solveNQueue(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<List<String>> ret = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pies = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        List<String> anAnswerList = new ArrayList<>();
        dfs(n, 0, cols, pies, nas, anAnswerList, ret);
        return ret;
    }

    public void dfs(int n, int row, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas,
                    List<String> anAnswerList, List<List<String>> ret) {
        if (row >= n) {
            // 此处需要克隆，因为anAnswerList还需要回溯
            ret.add(new ArrayList<>(anAnswerList));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (cols.contains(j) || pies.contains(row + j) || nas.contains(row - j)) {
                continue;
            }
            cols.add(j);
            pies.add(row + j);
            nas.add(row - j);
            String sRow = genAnAnswer(n, j);
            anAnswerList.add(sRow);
            dfs(n, row + 1, cols, pies, nas, anAnswerList, ret);
            cols.remove(j);
            pies.remove(row + j);
            nas.remove(row - j);
            // 回溯
            anAnswerList.remove(sRow);
        }
    }

    public String genAnAnswer(int n, int j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == j) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public List<String> cloneList(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<String> ret = new ArrayList<>();
        for (String s : list) {
            ret.add(s);
        }
        return ret;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> ret = nQueens.solveNQueue(5);
        System.out.println(ret.size());
        System.out.println(ret);
    }

}
