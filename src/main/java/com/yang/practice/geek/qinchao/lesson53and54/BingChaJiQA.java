package com.yang.practice.geek.qinchao.lesson53and54;

/**
 * leetcode 200 547 并查集
 *
 * @Author: yangguojun01
 * @Date: 2022/1/17
 */
public class BingChaJiQA {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        BingChaJi b = new BingChaJi(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    b.union(i, j);
                }
            }
        }
        return b.count();
    }

}

class BingChaJi {
    // 记录连通量
    private int count;
    // 节点x的根节点是parent[x]
    private int[] parent;

    public BingChaJi(int n) {
        // 一开始互不相通
        this.count = n;
        // 一开始每个节点是自己的父节点
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 返回某个节点p的根节点
     *
     * @param p
     * @return
     */
    public int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    /***
     * 将p和q连接, 如果两个节点被连通，那么则让其中的一个根节点连接到另一个节点的根节点上
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

    /***
     * 判断p和q是否连通:如果两个节点是连通的，那么他们一定拥有相同的根节点
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /***
     * 返回具体有多少个连通量
     * @return
     */
    public int count() {
        return count;
    }
}