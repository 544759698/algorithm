package com.yang.practice.jianzhioffer.qa47maxgiftvalue;

/**
 * @Author: yangguojun01
 * @Date: 2022/5/9
 */
public class MaxGiftValue {
    public int maxValue(int[][] grid) {
        int[][] maxValues = new int[grid.length][grid[0].length];
        maxValues[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            maxValues[i][0] = maxValues[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            maxValues[0][i] = maxValues[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                maxValues[i][j] = Math.max(maxValues[i - 1][j], maxValues[i][j - 1]) + grid[i][j];
            }
        }
        return maxValues[maxValues.length - 1][maxValues[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
        MaxGiftValue m = new MaxGiftValue();
        System.out.println(m.maxValue(grid));
    }
}
