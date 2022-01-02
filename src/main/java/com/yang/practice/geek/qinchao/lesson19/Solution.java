package com.yang.practice.geek.qinchao.lesson19;

/**
 * 寻找二叉树公共祖先
 * nums = {6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5} 2,8->6;2,4->2
 *
 * @Author: yangguojun01
 * @Date: 2022/1/3
 */
public class Solution {

    public int findAncestor(Node node, int value1, int value2) {
        if (node == null) {
            return -1;
        }
        if (node.value == value1 || node.value == value2) {
            return node.value;
        }
        int leftValue = findAncestor(node.left, value1, value2);
        int rightValue = findAncestor(node.right, value1, value2);
        // find 2
        if (leftValue >= 0 && rightValue >= 0) {
            return node.value;
        } else {
            // find 0 or 1
            return leftValue + rightValue + 1;
        }
    }

    public Node buildTree(int[] nums, int pos) {
        if (nums == null || nums.length == 0 || pos >= nums.length || nums[pos] == -1) {
            return null;
        }
        Node node = new Node(nums[pos]);
        node.left = buildTree(nums, pos * 2 + 1);
        node.right = buildTree(nums, pos * 2 + 2);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5};
        Solution s = new Solution();
        Node node = s.buildTree(nums, 0);
        System.out.println(s.findAncestor(node, 2, 4));
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
