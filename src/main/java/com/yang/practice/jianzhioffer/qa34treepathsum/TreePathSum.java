package com.yang.practice.jianzhioffer.qa34treepathsum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/10
 */
public class TreePathSum {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        dfs(root, deque, target, ret);
        return ret;
    }

    public void dfs(TreeNode root, Deque<TreeNode> deque, int target, List<List<Integer>> ret) {
        if (root == null) {
            return;
        }
        deque.offer(root);
        if (root != null && root.left == null && root.right == null) {
            if (checkSum(deque, target)) {
                ret.add(copy(deque));
            }
        }
        dfs(root.left, deque, target, ret);
        dfs(root.right, deque, target, ret);
        deque.removeLast();
    }

    public boolean checkSum(Deque<TreeNode> deque, int target) {
        int sum = 0;
        for (TreeNode node : deque) {
            sum += node.val;
        }
        return sum == target;
    }

    public List<Integer> copy(Deque<TreeNode> deque) {
        List<Integer> path = new ArrayList<>();
        for (TreeNode node : deque) {
            path.add(node.val);
        }
        return path;
    }

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum2(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }

    public static void main(String[] args) {
        TreePathSum t = new TreePathSum();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        List<List<Integer>> ret = t.pathSum2(n1, 3);
        System.out.println(ret);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
