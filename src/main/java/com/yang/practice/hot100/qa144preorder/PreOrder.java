package com.yang.practice.hot100.qa144preorder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/8/25
 */
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        preOrder(root, ret);
        return ret;
    }

    public void preOrder(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        }
        ret.add(node.val);
        preOrder(node.left, ret);
        preOrder(node.right, ret);
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
