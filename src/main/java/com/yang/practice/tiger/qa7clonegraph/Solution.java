package com.yang.practice.tiger.qa7clonegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2021/12/20
 */
public class Solution {

    public Node buildGraph(int[][] graph) {
        Node[] nodes = new Node[graph.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                nodes[i].neighbors.add(nodes[graph[i][j] - 1]);
            }
        }
        return nodes[0];
    }

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    public Node cloneGraph(Node node, HashMap<Node, Node> map) {
        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (map.containsKey(node)) {
            return map.get(node);
        }
        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node clone = new Node(node.val);
        // 哈希表存储
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            // 遍历该节点的邻居并更新克隆节点的邻居列表
            clone.neighbors.add(cloneGraph(neighbor, map));
        }
        //map.put(node, clone);     // 放这里是个大bug！！！会没有终止无限递归下去
        // 这里是clone
        return clone;
    }

    public static void main(String[] args) {
        int[][] graph = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Solution s = new Solution();
        Node node = s.buildGraph(graph);
        Node newNode = s.cloneGraph(node);
        System.out.println(node);
        System.out.println(newNode);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}