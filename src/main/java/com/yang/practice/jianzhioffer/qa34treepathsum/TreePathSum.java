package com.yang.practice.jianzhioffer.qa34treepathsum;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO 需要复习 递归+回溯
 *
 * @Author: yangguojun01
 * @Date: 2022/2/10
 */
public class TreePathSum {

    List<List<Integer>> ret = new ArrayList<>();
    // 通过队列offer和poll回溯
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        target = target - root.val;
        path.offer(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(path));
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
        List<List<Integer>> ret = t.pathSum(n1, 3);
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
