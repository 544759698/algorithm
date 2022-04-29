package com.yang.practice.geek.qinchao.lesson46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode120 三角形最小路径和，从第一层到最后一层的最小路径和
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * <p>
 * TODO:还有其他解法，如递归
 *
 * @Author: yangguojun01
 * @Date: 2022/1/12
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 记录到[i,j]时的最小路径
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        // 遍历行
        for (int i = 1; i < n; i++) {
            // j=0和j=i时dp只有一个取值，没有状态方程
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            // 遍历行内元素
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        // 取最小值
        int minPath = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            minPath = Math.min(minPath, dp[n - 1][i]);
        }
        return minPath;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>() {{
            add(2);
        }});
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        Triangle t = new Triangle();
        System.out.println(t.minimumTotal(triangle));
    }

}
