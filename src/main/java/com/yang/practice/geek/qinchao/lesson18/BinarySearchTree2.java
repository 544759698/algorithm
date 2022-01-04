package com.yang.practice.geek.qinchao.lesson18;

/**
 * @Author: yangguojun01
 * @Date: 2022/1/2
 */
public class BinarySearchTree2 {

    public boolean isValidBST(Node node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && min >= node.value) || (max != null && max <= node.value)) {
            return false;
        }
        return isValidBST(node.left, min, node.value) && isValidBST(node.right, node.value, max);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        BinarySearchTree2 s2 = new BinarySearchTree2();
        System.out.println(s2.isValidBST(n1, null, null));
    }

}
