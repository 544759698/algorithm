package com.yang.practice.hot100.qa101mirrortree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/24
 */
public class MirrorTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<TreeNode> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode top = queue.poll();
                levelList.add(top);
                if (top == null) {
                    continue;
                }
                queue.offer(top.left);
                queue.offer(top.right);
            }
            for (int j = 0; j < levelSize / 2; j++) {
                if (levelList.get(j) == null && levelList.get(levelSize - j - 1) == null) {
                    continue;
                }
                if (levelList.get(j) == null || levelList.get(levelSize - j - 1) == null
                        || levelList.get(j).val != levelList.get(levelSize - j - 1).val) {
                    return false;
                }
            }
        }
        return true;
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
