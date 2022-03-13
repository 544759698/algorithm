package com.yang.practice.geek.qinchao.lesson18;

/**
 * TODO remember
 *
 * @Author: yangguojun01
 * @Date: 2022/1/2
 */
public class BinarySearchTree2 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode treeNode, Integer min, Integer max) {
        if (treeNode == null) {
            return true;
        }
        if ((min != null && min >= treeNode.val) || (max != null && max <= treeNode.val)) {
            return false;
        }
        return dfs(treeNode.left, min, treeNode.val) && dfs(treeNode.right, treeNode.val, max);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(6);
        // 3的min值(下界)是从6那儿继承过来的
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        BinarySearchTree2 s2 = new BinarySearchTree2();
        System.out.println(s2.isValidBST(n1));
    }

}
