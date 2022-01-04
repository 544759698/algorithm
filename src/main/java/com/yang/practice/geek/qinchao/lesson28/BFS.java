package com.yang.practice.geek.qinchao.lesson28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: yangguojun01
 * @Date: 2022/1/4
 */
public class BFS {

    public List<Node> getBFS(Node node) {
        List<Node> ret = new ArrayList<>();
        if (node == null) {
            return ret;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node first = queue.poll();
            ret.add(first);
            if (first.left != null) {
                queue.add(first.left);
            }
            if (first.right != null) {
                queue.add(first.right);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        BFS b = new BFS();
        List<Node> ret = b.getBFS(n1);
        for (Node node : ret) {
            System.out.println(node.value);
        }
    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
