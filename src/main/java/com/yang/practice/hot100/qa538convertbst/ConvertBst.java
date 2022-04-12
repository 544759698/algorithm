package com.yang.practice.hot100.qa538convertbst;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/12
 */
public class ConvertBst {
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i).val;
            list.get(i).val = sum;
        }
        return root;
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root);
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
