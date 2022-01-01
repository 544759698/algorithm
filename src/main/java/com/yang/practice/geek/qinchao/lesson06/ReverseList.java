package com.yang.practice.geek.qinchao.lesson06;

/**
 * 单链表反转
 *
 * @Author: yangguojun01
 * @Date: 2021/12/26
 */
public class ReverseList {

    public Node reverseList(Node head) {
        Node curr = head;
        Node pre = null;
        while (curr != null) {
            Node tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
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
        ReverseList r = new ReverseList();
        Node newHead = r.reverseList(node1);
        while (newHead != null) {
            System.out.println(newHead.value);
            newHead = newHead.next;
        }
    }

}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
