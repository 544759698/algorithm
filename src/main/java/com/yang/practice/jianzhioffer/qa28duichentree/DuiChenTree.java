package com.yang.practice.jianzhioffer.qa28duichentree;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/8
 */
public class DuiChenTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkChild(root.left, root.right);
    }

    private boolean checkChild(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return checkChild(left.left, right.right) && checkChild(left.right, right.left);
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

