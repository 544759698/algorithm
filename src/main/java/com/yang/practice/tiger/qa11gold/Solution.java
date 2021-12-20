package com.yang.practice.tiger.qa11gold;

import java.util.Arrays;

/**
 * @Author: yangguojun01
 * @Date: 2021/12/20
 */
public class Solution {

    public int getGold(int[] houses) {
        int[] memo = new int[houses.length];
        Arrays.fill(memo, -1);
        return getMemo(0, memo, houses);
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
