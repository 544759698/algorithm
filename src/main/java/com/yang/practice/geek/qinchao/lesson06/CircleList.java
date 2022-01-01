package com.yang.practice.geek.qinchao.lesson06;

/**
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class CircleList {

    public boolean hasCircle(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        CircleList c = new CircleList();
        System.out.println(c.hasCircle(node1));
    }

}

