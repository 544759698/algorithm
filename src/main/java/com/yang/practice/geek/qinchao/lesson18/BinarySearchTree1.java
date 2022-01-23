package com.yang.practice.geek.qinchao.lesson18;

/**
 * leetcode98 判断是否为二叉搜索树，即左子树小于根节点，右子树大于根节点
 * 中序遍历方法，前置节点小于当前节点即可 TODO 待复习
 *
 * @Author: yangguojun01
 * @Date: 2022/1/2
 */
public class BinarySearchTree1 {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
        // return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        n1.left = new TreeNode(1);
        n1.right = new TreeNode(3);
        n1.left.left = new TreeNode(4);
        BinarySearchTree1 s1 = new BinarySearchTree1();
        System.out.println(s1.isValidBST(n1));
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
