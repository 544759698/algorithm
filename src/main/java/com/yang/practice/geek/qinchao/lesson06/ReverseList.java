package com.yang.practice.geek.qinchao.lesson06;

import com.yang.practice.geek.qinchao.common.Node;

/**
 * @Author: yangguojun01
 * @Date: 2021/12/26
 */
public class ReverseList {

    public Node reverseList(Node head) {
        Node curr = head;
        Node pre = null;
        while (curr != null) {
            Node tmp = curr.getNext();
            curr.setNext(pre);
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
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        ReverseList r = new ReverseList();
        Node newHead = r.reverseList(node1);
        while (newHead != null) {
            System.out.println(newHead.getValue());
            newHead = newHead.getNext();
        }
    }

}
