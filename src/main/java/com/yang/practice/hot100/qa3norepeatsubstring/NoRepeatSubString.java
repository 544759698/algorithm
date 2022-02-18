package com.yang.practice.hot100.qa3norepeatsubstring;

import java.util.HashMap;

/**
 * TODO 不是最优解
 *
 * @Author: yangguojun01
 * @Date: 2022/2/18
 */
public class NoRepeatSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s == "") {
            return 0;
        }
        char[] sArr = s.toCharArray();
        int i = 0;
        int maxLength = 0;
        while (i < sArr.length) {
            HashMap<Character, Integer> appeared = new HashMap<>();
            appeared.put(sArr[i], i);
            int j = i + 1;
            while (j < sArr.length) {
                if (!appeared.containsKey(sArr[j])) {
                    appeared.put(sArr[j], j);
                    j++;
                } else {
                    maxLength = Math.max(maxLength, j - i);
                    break;
                }
            }
            if (j == sArr.length) {
                maxLength = Math.max(maxLength, j - i);
                break;
            } else {
                i = appeared.get(sArr[j]) + 1;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        NoRepeatSubString n = new NoRepeatSubString();
        //        String s = "abcabcbb";
        String s = "pwwkew";
        System.out.println(n.lengthOfLongestSubstring(s));
    }

}
