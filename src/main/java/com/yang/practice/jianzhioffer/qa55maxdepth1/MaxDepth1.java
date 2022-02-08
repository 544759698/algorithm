package com.yang.practice.jianzhioffer.qa55maxdepth1;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/8
 */
public class MaxDepth1 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left) + 1, dfs(root.right) + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
