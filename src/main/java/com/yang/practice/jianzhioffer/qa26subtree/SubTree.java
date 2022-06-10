package com.yang.practice.jianzhioffer.qa26subtree;

/**
 * TODO 值得背下来
 * @Author: yangguojun01
 * @Date: 2022/2/7
 */
public class SubTree {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return checkTrees(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean checkTrees(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return checkTrees(a.left, b.left) && checkTrees(a.right, b.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
