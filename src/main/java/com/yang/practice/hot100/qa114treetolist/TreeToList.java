package com.yang.practice.hot100.qa114treetolist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/27
 */
public class TreeToList {

    public void flatten(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        dfs(root, nodes);
        for (int i = 1; i < nodes.size(); i++) {
            nodes.get(i - 1).left = null;
            nodes.get(i - 1).right = nodes.get(i);
        }
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
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
