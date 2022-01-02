package com.yang.practice.geek.qinchao.lesson18;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否为二叉搜索树，及左子树小于根节点，右子树大于根节点
 * 中序遍历方法，前置节点小于当前节点即可
 *
 * @Author: yangguojun01
 * @Date: 2022/1/2
 */
public class Solution1 {

    public boolean isValidBST(Node node) {
        Queue<Integer> queue = new LinkedList<>();
        Solution1 s1 = new Solution1();
        return s1.inOrderForValidBST(node, queue);
    }

    private boolean inOrderForValidBST(Node node, Queue<Integer> queue) {
        if (node == null) {
            return true;
        }
        inOrderForValidBST(node.left, queue);
        if (!queue.isEmpty() && queue.poll() >= node.value) {
            return false;
        }
        queue.add(node.value);
        inOrderForValidBST(node.right, queue);
        return true;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        Solution1 s1 = new Solution1();
        System.out.println(s1.isValidBST(n1));
    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
