package com.yang.practice.geek.qinchao.lesson18;

/**
 * @Author: yangguojun01
 * @Date: 2022/1/2
 */
public class BinarySearchTree2 {

    public boolean isValidBST(TreeNode treeNode, Integer min, Integer max) {
        if (treeNode == null) {
            return true;
        }
        if ((min != null && min >= treeNode.val) || (max != null && max <= treeNode.val)) {
            return false;
        }
        return isValidBST(treeNode.left, min, treeNode.val) && isValidBST(treeNode.right, treeNode.val, max);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(3);
        BinarySearchTree2 s2 = new BinarySearchTree2();
        System.out.println(s2.isValidBST(n1, null, null));
    }

}
