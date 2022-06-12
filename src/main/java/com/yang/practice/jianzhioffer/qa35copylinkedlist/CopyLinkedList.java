package com.yang.practice.jianzhioffer.qa35copylinkedlist;

import java.util.HashMap;

/**
 * @Author: yangguojun01
 * @Date: 2022/6/12
 */
public class CopyLinkedList {

    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node newNode = new Node(head.val);
            // 注意
            map.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }

        return map.get(head);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
