package com.yang.practice.jianzhioffer.qa12matrixpath;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/16
 */
public class MatrixPath {
    // TODO 没做对
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean ret = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret = checkPath(visited, i, j, "", board, word);
                if (ret) {
                    break;
                }
            }
        }
        return ret;
    }

    public boolean checkPath(boolean[][] visited, int i, int j, String str, char[][] board, String word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        String newStr = str + board[i][j];
        if (newStr == word) {
            return true;
        }
        visited[i][j] = true;
        if (checkPath(visited, i + 1, j, newStr, board, word)) {
            return true;
        }
        if (checkPath(visited, i - 1, j, newStr, board, word)) {
            return true;
        }
        if (checkPath(visited, i, j + 1, newStr, board, word)) {
            return true;
        }
        if (checkPath(visited, i, j - 1, newStr, board, word)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

}
