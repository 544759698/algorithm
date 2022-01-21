package com.yang.practice.geek.qinchao.lesson06;

/**
 * leetcode24 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 如：给定 1->2->3->4, 应该返回 2->1->4->3.
 * TODO 待复习
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class SwapTwoNodes {

    public Node swapTwoNodes(Node head) {
        Node dump = new Node(-1);
        dump.next = head;
        head = dump;
        while (head.next != null && head.next.next != null) {
            Node n1 = head.next;
            Node n2 = head.next.next;
            head.next = n2;
            // 下面两步必须此顺序，否则n2.next变了后再把n1.next指向n2.next就不对了
            n1.next = n2.next;
            n2.next = n1;
            head = n1;
        }
        return dump.next;
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
        SwapTwoNodes s = new SwapTwoNodes();
        Node newHead = s.swapTwoNodes(node1);
        while (newHead != null) {
            System.out.println(newHead.value);
            newHead = newHead.next;
        }
    }

}
