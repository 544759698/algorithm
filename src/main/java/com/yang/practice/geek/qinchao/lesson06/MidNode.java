package com.yang.practice.geek.qinchao.lesson06;

/**
 * 求链表的中间结点
 * 偶数个节点时返回null
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class MidNode {

    public Node findMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 判断是否为偶数个节点
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
        MidNode m = new MidNode();
        Node node = m.findMidNode(node1);
        System.out.println(node == null ? "null" : node.value);
    }
}
