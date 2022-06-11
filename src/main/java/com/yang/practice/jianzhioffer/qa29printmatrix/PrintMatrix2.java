package com.yang.practice.jianzhioffer.qa29printmatrix;

/**
 * @Author: yangguojun01
 * @Date: 2022/6/11
 */
public class PrintMatrix2 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int[] ret = new int[(bottom + 1) * (right + 1)];
        int idx = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ret[idx] = matrix[top][i];
                idx++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                ret[idx] = matrix[i][right];
                idx++;
            }
            // 这里判断有没有剩余空间
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    ret[idx] = matrix[bottom][i];
                    idx++;
                }
                for (int i = bottom - 1; i >= top + 1; i--) {
                    ret[idx] = matrix[i][left];
                    idx++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ret;
    }

    public static void main(String[] args) {
        PrintMatrix2 p = new PrintMatrix2();
        //int[][] matrix = {{1, 2}, {3, 4}};
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(p.spiralOrder(matrix));
    }

}
