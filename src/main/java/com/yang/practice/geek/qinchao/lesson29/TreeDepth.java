package com.yang.practice.geek.qinchao.lesson29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的最大深度和最小深度
 *
 * @Author: yangguojun01
 * @Date: 2022/1/5
 */
public class TreeDepth {

    /***
     * 取最大深度（非递归）
     * @param node
     * @return
     */
    public int getMaxDepth1(Node node) {
        if (node == null) {
            return 0;
        }
        List<List<Node>> levelList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        List<Node> firstLevel = new ArrayList<>();
        firstLevel.add(node);
        levelList.add(firstLevel);
        while (!queue.isEmpty()) {
            List<Node> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node first = queue.poll();
                if (first.left != null) {
                    queue.add(first.left);
                    level.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                    level.add(first.right);
                }
            }
            if (level.size() > 0) {
                levelList.add(level);
            }
        }
        return levelList.size();
    }

    /***
     * 取最大深度（递归）
     * @param node
     * @return
     */
    public int getMaxDepth2(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getMaxDepth2(node.left) + 1, getMaxDepth2(node.right) + 1);
    }

    /**
     * 取最小深度（递归）
     *
     * @param node
     * @return
     */
    public int getMinDepth(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null) {
            return getMinDepth(node.right) + 1;
        }
        if (node.right == null) {
            return getMinDepth(node.left) + 1;
        }
        return Math.min(getMinDepth(node.left) + 1, getMinDepth(node.right) + 1);
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
        //        n2.left = n4;
        //        n2.right = n5;
        n3.left = n6;
        TreeDepth t = new TreeDepth();
        System.out.println(t.getMaxDepth1(n1));
        System.out.println(t.getMaxDepth2(n1));
        System.out.println(t.getMinDepth(n1));
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
