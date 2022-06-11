package com.yang.practice.jianzhioffer.qa33bstpost;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/9
 */
public class BstPost {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        // postorder[j]为根节点
        if (i >= j) {
            return true;
        }
        int p = i;
        // 左子树都小于根节点
        while (postorder[p] < postorder[j]) {
            p++;
        }
        // 找到左右子树分界
        int m = p;
        // 右子树都大于根节点
        while (postorder[p] > postorder[j]) {
            p++;
        }
        // p和j需要相等才是二叉搜索树
        if (p != j) {
            return false;
        }
        // 递归判断左右子树
        return recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

}
