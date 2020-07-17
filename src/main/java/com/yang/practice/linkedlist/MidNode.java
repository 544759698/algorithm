package com.yang.practice.linkedlist;

/**
 * 求链表的中间结点
 * 偶数个节点时返回null
 */
public class MidNode {
    public static Node findMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null && fast.next.next == null) {
            return null;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
        Node.print(node1);
        Node node = findMidNode(node1);
        System.out.println(node == null ? "null" : node.getData());
    }
}
