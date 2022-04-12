package com.yang.practice.tiger.qa6preordertree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归前中后序遍历
 *
 * @Author: yangguojun01
 * @Date: 2021/12/15
 */

class Element {
    int type;
    Node node;

    public Element(int type, Node node) {
        // 0-visit 1-output
        this.type = type;
        this.node = node;
    }
}

public class Solution2 {

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
        Stack<Element> stack = new Stack<>();
        // 0-visit 1-output
        stack.push(new Element(0, node));
        while (!stack.isEmpty()) {
            Element curr = stack.pop();
            if (curr.node == null) {
                continue;
            }
            if (curr.type == 1) {
                ret.add(curr.node.value);
            } else {
                stack.push(new Element(0, curr.node.right));
                stack.push(new Element(0, curr.node.left));
                stack.push(new Element(1, curr.node));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, -1, 4, 5, 6};
        Solution2 s = new Solution2();
        Node node = s.buildTree(nums, 0);
        List<Integer> ret = new ArrayList<>();
        s.preOrderTree(node, ret);
        for (Integer value : ret) {
            System.out.println(value);
        }
    }

}
