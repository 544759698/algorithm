package com.yang.algorithm.linkedlist;

/**
 * 单链表反转
 * Created by Administrator on 2018/10/10.
 */
public class LinkedListReverse {

    public static Node reverse(Node head) {
        Node newHead = null;
        Node previousNode = null;
        Node currentNode = head;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                newHead = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        print(node1);
        Node node = reverse(node1);
        print(node);
    }

    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.getData() + "->");
            node = node.next;
        }
        System.out.println();
    }
}

class Node {
    private int data;
    public Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
