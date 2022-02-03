package com.yang.practice.geek.qinchao.lesson19;

/**
 * leetcode 235 236 寻找二叉树公共祖先
 * nums = {6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5} 2,8->6;2,4->2
 *
 * @Author: yangguojun01
 * @Date: 2022/1/3
 */
public class Ancestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null && rightNode == null) {
            return null;
        }
        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode != null ? leftNode : rightNode;
    }

    public int findAncestor(TreeNode treeNode, int value1, int value2) {
        if (treeNode == null) {
            return -1;
        }
        if (treeNode.val == value1 || treeNode.val == value2) {
            return treeNode.val;
        }
        int leftValue = findAncestor(treeNode.left, value1, value2);
        int rightValue = findAncestor(treeNode.right, value1, value2);
        // find 2
        if (leftValue >= 0 && rightValue >= 0) {
            return treeNode.val;
        } else {
            // find 0 or 1
            return leftValue + rightValue + 1;
        }
    }

    public TreeNode buildTree(int[] nums, int pos) {
        if (nums == null || nums.length == 0 || pos >= nums.length || nums[pos] == -1) {
            return null;
        }
        TreeNode treeNode = new TreeNode(nums[pos]);
        treeNode.left = buildTree(nums, pos * 2 + 1);
        treeNode.right = buildTree(nums, pos * 2 + 2);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5};
        Ancestor s = new Ancestor();
        TreeNode treeNode = s.buildTree(nums, 0);
        System.out.println(s.findAncestor(treeNode, 2, 4));
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
