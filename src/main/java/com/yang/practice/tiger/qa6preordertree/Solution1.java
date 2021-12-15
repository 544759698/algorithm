package com.yang.practice.tiger.qa6preordertree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2021/12/15
 */

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class Solution1 {

    public Node buildTree(int[] nums, int pos) {
        if (pos >= nums.length || nums[pos] == -1) {
            return null;
        }
        Node node = new Node(nums[pos]);
        node.left = buildTree(nums, pos * 2 + 1);
        node.right = buildTree(nums, pos * 2 + 2);
        return node;
    }

    public List<Integer> preOrderTree(Node node, List<Integer> ret) {
        if (node == null || node.value < 0) {
            return null;
        }
        ret.add(node.value);
        preOrderTree(node.left, ret);
        preOrderTree(node.right, ret);
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, -1, 4, 5, 6};
        Solution1 s = new Solution1();
        Node node = s.buildTree(nums, 0);
        List<Integer> ret = new ArrayList<>();
        s.preOrderTree(node, ret);
        for (Integer value : ret) {
            System.out.println(value);
        }
    }

}
