package com.yang.practice.jianzhioffer.qa647countsubstring;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/26
 */
public class CountSubstring {

    public int countSubstrings(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (checkSubstring(s, i, j)) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public boolean checkSubstring(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
