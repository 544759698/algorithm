package com.yang.practice.jianzhioffer.qa226reversetree;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/16
 */
public class ReverseTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode curr = root;
        if (curr.left == null && curr.right == null) {
            return curr;
        }
        TreeNode tmp = curr.left;
        curr.left = curr.right;
        curr.right = tmp;
        invertTree(curr.left);
        invertTree(curr.right);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
