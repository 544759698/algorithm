package com.yang.practice.tiger.qa11gold;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/house-robber/
 * 给定一个数组代表金子数量，不能连偷，取最大值
 *
 * @Author: yangguojun01
 * @Date: 2021/12/20
 */
public class Solution {

    public int getGold(int[] golds) {
        // memo[i]表示从第i个位置偷到最后的最大值
        int[] memo = new int[golds.length];
        Arrays.fill(memo, -1);
        getMemo(0, memo, golds);
        return memo[0];
        // 最后两句等价于 return getMemo(0, memo, golds);
    }

    public int getMemo(int id, int[] memo, int[] houses) {
        if (id >= houses.length) {
            return 0;
        }
        if (memo[id] != -1) {
            return memo[id];
        }
        int selected = houses[id] + getMemo(id + 2, memo, houses);
        int unselected = getMemo(id + 1, memo, houses);
        memo[id] = Math.max(selected, unselected);
        return memo[id];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] houses = {3, 5, 2, 10};
        System.out.println(s.getGold(houses));
    }

}
