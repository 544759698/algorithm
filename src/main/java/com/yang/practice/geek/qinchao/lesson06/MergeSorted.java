package com.yang.practice.geek.qinchao.lesson06;

/**
 * 合并两个有序链表
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class MergeSorted {

    public Node mergeSorted(Node left, Node right) {

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node head;
        if (left.value < right.value) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }
        Node p = head;
        while (left != null && right != null) {
            if (left.value < right.value) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left != null) {
            p.next = left;
        } else {
            p.next = right;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        node1.next = node3;
        node2.next = node4;
        node3.next = node5;
        node4.next = node6;
        node5.next = node7;
        node6.next = node8;
        node7.next = node9;
        MergeSorted m = new MergeSorted();
        Node node = m.mergeSorted(node1, node2);
        System.out.println(node.value);
    }
}
