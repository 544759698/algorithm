package com.yang.practice.geek.qinchao.lesson46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * leetcode 120 三角形最小路径和，从第一层到最后一层的最小路径和
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * <p>
 * 自底向上找，结果收敛（状态压缩）
 * TODO:还有其他解法，如递归
 *
 * @Author: yangguojun01
 * @Date: 2022/1/12
 */
public class Triangle {

    public int minPath(List<List<Integer>> triangle) {
        if (CollectionUtils.isEmpty(triangle)) {
            return 0;
        }
        int rowCount = triangle.size();
        int[][] dp = new int[rowCount + 1][rowCount + 1]; // 底层多铺一层，值全为0
        for (int i = rowCount - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
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
        System.out.println(t.minPath(triangle));
    }

}
