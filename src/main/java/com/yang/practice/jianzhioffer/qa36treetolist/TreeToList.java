package com.yang.practice.jianzhioffer.qa36treetolist;

/**
 * TODO 这种题有啥意义
 * @Author: yangguojun01
 * @Date: 2022/2/8
 */
public class TreeToList {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inOrder(Node curr) {
        if (curr == null) {
            return;
        }
        inOrder(curr.left);
        if (pre != null) {
            pre.right = curr;
        } else {
            head = curr;
        }
        curr.left = pre;
        pre = curr;
        inOrder(curr.right);
    }

    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(1);
        Node n5 = new Node(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        TreeToList t = new TreeToList();

        System.out.println(t.treeToDoublyList(n1));
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
