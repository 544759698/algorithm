package com.yang.practice.geek.qinchao.lesson37and38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 212 79 单词搜索
 * TODO 待复习 字典树+回溯
 *
 * @Author: yangguojun01
 * @Date: 2022/1/8
 */
public class WordSearch {

    public List<String> searchWords(char[][] board, List<String> words) {
        if (words == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }
        Set<String> ret = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, trie, visited, "", i, j, ret);
            }
        }
        return new ArrayList<>(ret);
    }

    public void dfs(char[][] board, Trie trie, boolean[][] visited, String str, int i, int j, Set<String> ret) {
        if (i < 0 || i >= board.length || j < 0 || j >= -board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        str += board[i][j];
        if (!trie.startWith(str)) {
            return;
        }
        if (trie.search(str)) {
            ret.add(str);
        }
        visited[i][j] = true;
        dfs(board, trie, visited, str, i - 1, j, ret);
        dfs(board, trie, visited, str, i + 1, j, ret);
        dfs(board, trie, visited, str, i, j - 1, ret);
        dfs(board, trie, visited, str, i, j + 1, ret);
        visited[i][j] = false;
    }

}
