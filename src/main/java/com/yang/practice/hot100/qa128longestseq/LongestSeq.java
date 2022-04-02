package com.yang.practice.hot100.qa128longestseq;

import java.util.HashSet;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/2
 */
public class LongestSeq {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLength++;
                }
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }
}
