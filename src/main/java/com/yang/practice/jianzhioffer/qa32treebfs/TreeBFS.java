package com.yang.practice.jianzhioffer.qa32treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/9
 */
public class TreeBFS {
    public int[] levelOrder1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode top = queue.poll();
                ret.add(top.val);
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
        }
        int[] retArr = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            retArr[i] = ret.get(i);
        }
        return retArr;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode top = queue.poll();
                item.add(top.val);
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            ret.add(item);
        }
        return ret;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode top = queue.poll();
                item.add(top.val);
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            ret.add(item);
        }
        for (int i = 0; i < ret.size(); i++) {
            if (i % 2 == 1) {
                List<Integer> originalList = ret.get(i);
                List<Integer> reverseList = new ArrayList<>();
                for (int j = originalList.size() - 1; j >= 0; j--) {
                    reverseList.add(originalList.get(j));
                }
                ret.set(i, reverseList);
            }
        }
        return ret;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
