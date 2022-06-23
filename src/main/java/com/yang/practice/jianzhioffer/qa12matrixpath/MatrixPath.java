package com.yang.practice.jianzhioffer.qa12matrixpath;

/**
 * TODO 需要复习
 *
 * @Author: yangguojun01
 * @Date: 2022/2/16
 */
public class MatrixPath {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean ret = checkPath(board, i, j, visited, word, 0);
                if (ret) {
                    // 这里直接return
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPath(char[][] board, int i, int j, boolean[][] visited, String word, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || k > word.length() - 1
                || board[i][j] != word.charAt(k) || visited[i][j]) {
            return false;
        }
        if (board[i][j] == word.charAt(k) && k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        if (checkPath(board, i + 1, j, visited, word, k + 1) || checkPath(board, i - 1, j, visited, word, k + 1)
                || checkPath(board, i, j + 1, visited, word, k + 1) || checkPath(board, i, j - 1, visited, word,
                k + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        //        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        //        String word = "ABCCEDFFF";
        char[][] board = {{'a'}, {'a'}};
        String word = "aaa";
        MatrixPath mp = new MatrixPath();
        System.out.println(mp.exist(board, word));
    }

}
