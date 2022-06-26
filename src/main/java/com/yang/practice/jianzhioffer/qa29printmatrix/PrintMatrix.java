package com.yang.practice.jianzhioffer.qa29printmatrix;

/**
 * TODO 需要练习 1
 * @Author: yangguojun01
 * @Date: 2022/3/6
 */
public class PrintMatrix {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ret = new int[m * n];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIdx = 0;
        int row = 0, col = 0;
        int retIdx = 0;
        boolean[][] visited = new boolean[m][n];
        while (retIdx < ret.length) {
            ret[retIdx] = matrix[row][col];
            visited[row][col] = true;
            int nextRow = row + direction[directionIdx][0];
            int nextCol = col + direction[directionIdx][1];
            if (nextRow < 0 || nextRow >= m || nextCol >= n || nextCol < 0
                    || visited[nextRow][nextCol]) {
                directionIdx = (directionIdx + 1) % 4;
            }
            row = row + direction[directionIdx][0];
            col = col + direction[directionIdx][1];
            retIdx++;
        }
        return ret;
    }

    public static void main(String[] args) {
        //        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2}, {3, 4}};
        PrintMatrix p = new PrintMatrix();
        System.out.println(p.spiralOrder(matrix));
    }

}
