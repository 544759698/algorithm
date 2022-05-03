package com.yang.practice.hot100.qa3norepeatsubstring;

import java.util.HashSet;

/**
 * TODO 不是最优解
 *
 * @Author: yangguojun01
 * @Date: 2022/2/18
 */
public class NoRepeatSubString {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s == null || s.length() == 0) {
            return maxLength;
        }
        HashSet<Character> appeared = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            appeared.clear();
            appeared.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (appeared.contains(s.charAt(j))) {
                    break;
                }
                appeared.add(s.charAt(j));
            }
            maxLength = Math.max(maxLength, appeared.size());
        }
        return maxLength;
    }

    // TODO 考虑滑动窗口

    public static void main(String[] args) {
        NoRepeatSubString n = new NoRepeatSubString();
        //        String s = "abcabcbb";
        String s = "pwwkew";
        System.out.println(n.lengthOfLongestSubstring(s));
    }

}
