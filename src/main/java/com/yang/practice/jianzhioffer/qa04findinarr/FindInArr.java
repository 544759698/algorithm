package com.yang.practice.jianzhioffer.qa04findinarr;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/14
 */
public class FindInArr {
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int rowLeft = 0;
        int rowRight = matrix.length - 1;
        while (rowLeft < rowRight) {
            int mid = rowLeft + (rowRight - rowLeft) / 2;
            if (matrix[0][mid] < target) {
                rowLeft = mid + 1;
            } else if (matrix[0][mid] > target) {
                rowRight = mid - 1;
            } else {
                return true;
            }
        }
        if (rowLeft < 0) {
            return false;
        }
        int colMin = 0;
        int colMax = matrix[rowLeft].length - 1;
        while (colMin < colMax) {
            int mid = colMin + (colMax - colMin) / 2;
            if (matrix[rowLeft][mid] < target) {
                colMin = mid + 1;
            } else if (matrix[rowLeft][mid] > target) {
                colMax = mid;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            int num = matrix[i][j];
            if (num == target) {
                return true;
            }
            if (num < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        FindInArr f = new FindInArr();
        boolean ret = f.findNumberIn2DArray(matrix, 5);
        System.out.println(ret);
    }

}
