package com.yang.practice.jianzhioffer.qa07buildtree;

import java.util.HashMap;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/7
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, inorderMap, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> inorderMap,
                                int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 前序遍历中根节点索引
        int preorderRoot = preLeft;
        // 中序遍历中根节点索引
        int inorderRoot = inorderMap.get(preorder[preorderRoot]);
        // 找到根节点
        TreeNode root = new TreeNode(inorder[inorderRoot]);
        // 左子树长度
        int leftSize = inorderRoot - inLeft;
        // 重建左子树
        root.left = myBuildTree(preorder, inorder, inorderMap,
                preLeft + 1, preLeft + leftSize, inLeft, inorderRoot - 1);
        // 重建右子树
        root.right = myBuildTree(preorder, inorder, inorderMap,
                preLeft + leftSize + 1, preRight, inorderRoot + 1, inRight);
        return root;
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
