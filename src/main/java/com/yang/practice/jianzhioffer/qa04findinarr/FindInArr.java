package com.yang.practice.jianzhioffer.qa04findinarr;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/14
 */
public class FindInArr {

    /***
     * 思路错误，找19，在4那一列，不在5那一列，所以不能用二分法找
     *  [[1,2,3,4,5],
     *  [6,7,8,9,10],
     * [11,12,13,14,15],
     * [16,17,18,19,20],
     * [21,22,23,24,25]]
     * 19
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int targetCol = -1;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == target || (i + 1 < matrix[0].length && matrix[0][i + 1] == target)) {
                return true;
            }
            if (matrix[0][i] > target) {
                break;
            }
            if (matrix[0][i] < target && (i + 1 < matrix[0].length && matrix[0][i + 1] > target)) {
                targetCol = i;
                break;
            }
            if (i == matrix[0].length - 1 && matrix[0][i] < target) {
                targetCol = i;
            }
        }
        if (targetCol < 0) {
            return false;
        }
        int rowMin = 0;
        int rowMax = matrix.length - 1;
        while (rowMin <= rowMax) {
            int mid = rowMin + (rowMax - rowMin) / 2;
            if (matrix[mid][targetCol] < target) {
                rowMin = mid + 1;
            } else if (matrix[mid][targetCol] > target) {
                rowMax = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /*** 这个才是正解！！！***/
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            }
            if (num < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //        int[][] matrix = {
        //                {1, 4, 7, 11, 15},
        //                {2, 5, 8, 12, 19},
        //                {3, 6, 9, 16, 22},
        //                {10, 13, 14, 17, 24},
        //                {18, 21, 23, 26, 30}
        //        };
        //                int[][] matrix = {{-1, 3}};
        int[][] matrix = {{5}, {6}};
        FindInArr f = new FindInArr();
        boolean ret = f.findNumberIn2DArray1(matrix, 6);
        System.out.println(ret);
    }

}
