package com.yang.practice.geek.qinchao.lesson29;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 104 111 根节点到叶子节点的最大深度和最小深度，所谓叶子节点，是指左右孩子都为空的节点才是叶子节点
 * 所以求最小深度的时候，如果左子树为空，则返回右子树的最小深度，反之亦然
 *
 * @Author: yangguojun01
 * @Date: 2022/1/5
 */
public class TreeDepth {

    /***
     * 取最大深度（递归）
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    /***
     * 取最大深度（非递归）
     * @param root
     * @return
     */
    public int getMaxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ret = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode first = queue.poll();
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
            }
            ret++;
        }
        return ret;
    }

    /**
     * 取最小深度（递归）
     * TODO 最小深度还需要理解下
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左右孩子都为空的节点才是叶子节点，如果左子树为空，右子树不为空，说明最小深度是 1 + 右子树的深度，反之亦然
        // 当一个左子树为空，右不为空，这时并不是最低点
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        // 当一个右子树为空，左不为空，这时并不是最低点
        if (root.right == null && root.left != null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    // 非递归
    //    class Solution {
    //        class QueueNode {
    //            TreeNode node;
    //            int depth;
    //
    //            public QueueNode(TreeNode node, int depth) {
    //                this.node = node;
    //                this.depth = depth;
    //            }
    //        }
    //
    //        public int minDepth(TreeNode root) {
    //            if (root == null) {
    //                return 0;
    //            }
    //
    //            Queue<QueueNode> queue = new LinkedList<QueueNode>();
    //            queue.offer(new QueueNode(root, 1));
    //            while (!queue.isEmpty()) {
    //                QueueNode nodeDepth = queue.poll();
    //                TreeNode node = nodeDepth.node;
    //                int depth = nodeDepth.depth;
    //                if (node.left == null && node.right == null) {
    //                    return depth;
    //                }
    //                if (node.left != null) {
    //                    queue.offer(new QueueNode(node.left, depth + 1));
    //                }
    //                if (node.right != null) {
    //                    queue.offer(new QueueNode(node.right, depth + 1));
    //                }
    //            }
    //
    //            return 0;
    //        }
    //    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        //        n2.left = n4;
        //        n2.right = n5;
        n3.left = n6;
        TreeDepth t = new TreeDepth();
        System.out.println(t.maxDepth(n1));
        System.out.println(t.getMaxDepth2(n1));
        System.out.println(t.minDepth(n1));
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
