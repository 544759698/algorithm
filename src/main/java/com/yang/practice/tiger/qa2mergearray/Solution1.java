package com.yang.practice.tiger.qa2mergearray;

/**
 * https://leetcode.cn/problems/merge-sorted-array/
 *
 * @Author: yangguojun01
 * @Date: 2021/12/13
 */
public class Solution1 {

    public void mergeArray(int[] num1, int length1, int[] num2, int length2) {
        int pos1 = length1 - 1;
        int pos2 = length2 - 1;
        int last = num1.length - 1;
        while (last != -1) {
            if (pos1 == -1 || (pos2 != -1 && num1[pos1] < num2[pos2])) {
                num1[last] = num2[pos2];
                last--;
                pos2--;
            } else {
                num1[last] = num1[pos1];
                last--;
                pos1--;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int[] num1 = new int[] {2, 3, 6, 0, 0, 0};
        s1.mergeArray(num1, 3, new int[] {4, 5, 9}, 3);
        for (int num : num1) {
            System.out.println(num);
        }
    }

}
