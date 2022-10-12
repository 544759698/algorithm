package com.yang.practice.tiger.qa5findancestor;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @Author: yangguojun01
 * @Date: 2021/12/21
 */

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class Solution {

    public Node buildTree(int[] nums, int pos) {
        if (nums == null || pos >= nums.length || nums[pos] == -1) {
            return null;
        }
        Node node = new Node(nums[pos]);
        node.left = buildTree(nums, 2 * pos + 1);
        node.right = buildTree(nums, 2 * pos + 2);
        return node;
    }

    public int findAncestor(Node root, int value1, int value2) {
        if (root == null) {
            return -1;
        }
        if (root.value == value1 || root.value == value2) {
            return root.value;
        }
        int leftValue = findAncestor(root.left, value1, value2);
        int rightValue = findAncestor(root.right, value1, value2);
        if (leftValue == -1 || rightValue == -1) {
            // find 0 or find 1
            return leftValue + rightValue + 1;
        }
        // find 2
        return root.value;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -1, 4, 5, 6};
        Solution s = new Solution();
        Node node = s.buildTree(nums, 0);
        System.out.println(s.findAncestor(node, 2, 6));
    }

}
