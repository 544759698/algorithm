package com.yang.algorithm.linkedlist;

/**
 * 删除倒数第N个节点
 */
public class DeleteLastN {
    public static Node deleteLastN(Node head, int n) {
        int i = 0;
        Node fast = head;
        while (i < n && fast != null) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            return null;
        }
        Node slow = head;
        Node prev = null;
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) {
            prev.next = prev.next.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node.print(node1);
        Node node = deleteLastN(node1, 3);
        Node.print(node1);
    }
}
