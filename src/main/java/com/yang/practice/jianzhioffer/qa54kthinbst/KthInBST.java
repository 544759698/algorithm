package com.yang.practice.jianzhioffer.qa54kthinbst;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/7
 */
public class KthInBST {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return this.res;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        if (k == 0) {
            return;
        }
        this.k--;
        if (k == 0) {
            this.res = root.val;
        }
        inOrder(root.left);
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

