package com.yang.practice.everyday;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: yangguojun01
 * @Date: 2020/11/17
 */
public class P1117 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        cache.get(2);
        cache.put(1, 4);
        printCache(cache);
    }

    private static void printCache(LRUCache cache) {
        for (Node node : cache.cacheList) {
            System.out.print(node.key + ":" + node.val + " ");
        }
        System.out.println();
    }

}

class LRUCache {
    int cap;
    Map<Integer, Node> cacheMap;
    LinkedList<Node> cacheList;

    public LRUCache(int cap) {
        this.cap = cap;
        cacheMap = new HashMap<>();
        cacheList = new LinkedList<>();
    }

    public void put(Integer key, Integer val) {
        Node newNode = new Node(key, val);
        Node node = cacheMap.get(key);
        if (node != null) {
            System.out.println(cacheList.remove(node));
            cacheList.addFirst(newNode);
        } else {
            if (cacheList.size() == cap) {
                Node last = cacheList.removeLast();
                cacheMap.remove(last.key);
            }
            cacheList.addFirst(newNode);
            cacheMap.put(key, newNode);
        }
    }

    public Integer get(Integer key) {
        Node node = cacheMap.get(key);
        if (node != null) {
            put(node.key, node.val);
            return node.val;
        }
        return -1;
    }

}

class Node {
    Integer key;
    Integer val;
    Node pre, next;

    public Node(Integer key, Integer val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }

        Node o = (Node) obj;
        return o.key.equals(key) && o.val.equals(val);
    }

    @Override
    public int hashCode() {
        return key.hashCode() + val.hashCode();
    }
}
