package com.yang.practice.geek.qinchao.lesson28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode102 二叉树的层序遍历
 *
 * @Author: yangguojun01
 * @Date: 2022/1/4
 */
public class BFS {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // TODO queue的size就是每层的节点数
            int levelSize = queue.size();
            List<Integer> levelRet = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                levelRet.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            ret.add(levelRet);
        }
        return ret;
    }

    public List<TreeNode> getBFS(TreeNode treeNode) {
        List<TreeNode> ret = new ArrayList<>();
        if (treeNode == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            ret.add(first);
            if (first.left != null) {
                queue.add(first.left);
            }
            if (first.right != null) {
                queue.add(first.right);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        BFS b = new BFS();
        List<TreeNode> ret = b.getBFS(n1);
        for (TreeNode treeNode : ret) {
            System.out.println(treeNode.val);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
