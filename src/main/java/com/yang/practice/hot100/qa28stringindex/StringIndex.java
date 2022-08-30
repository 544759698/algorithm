package com.yang.practice.hot100.qa28stringindex;

/**
 * @Author: yangguojun01
 * @Date: 2022/8/30
 */
public class StringIndex {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(j + i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
