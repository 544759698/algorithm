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
            nodes[i] = new Node();
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                nodes[i].neighbors.add(nodes[j]);
            }
        }
        return nodes[0];
    }

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    public Node cloneGraph(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node();
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor, map));
        }
        //map.put(node, clone);     // 放这里是个大bug！！！
        return clone;               // 这里是clone
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {0}, {0, 2}};
        Solution s = new Solution();
        Node node = s.buildGraph(graph);
        Node newNode = s.cloneGraph(node);
        System.out.println(node);
        System.out.println(newNode);
    }
}

class Node {
    List<Node> neighbors;

    public Node() {
        neighbors = new ArrayList<>();
    }
}