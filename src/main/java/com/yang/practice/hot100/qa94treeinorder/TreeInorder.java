package com.yang.practice.hot100.qa94treeinorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/13
 */
public class TreeInorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNodeElement> stack = new Stack<>();
        stack.add(new TreeNodeElement(root, 0));
        while (!stack.isEmpty()) {
            TreeNodeElement top = stack.pop();
            if (top.type == 1) {
                ret.add(top.node.val);
            } else {
                if (top.node.right != null) {
                    stack.add(new TreeNodeElement(top.node.right, 0));
                }
                if (top.node != null) {
                    stack.add(new TreeNodeElement(top.node, 1));
                }
                if (top.node.left != null) {
                    stack.add(new TreeNodeElement(top.node.left, 0));
                }
            }
        }
        return ret;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        inorder(root, ret);
        return ret;
    }

    private void inorder(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        }
        inorder(node.left, ret);
        if (node != null) {
            ret.add(node.val);
        }
        inorder(node.right, ret);
    }
}

class TreeNodeElement {
    TreeNode node;
    // 0-input 1-output
    int type;

    public TreeNodeElement(TreeNode node, int type) {
        this.node = node;
        this.type = type;
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

