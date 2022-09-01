package com.yang.practice.hot100.qa9palindrome;

/**
 * @Author: yangguojun01
 * @Date: 2022/9/1
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String xStr = String.valueOf(x);
        int i = 0;
        int j = xStr.length() - 1;
        while (j > i) {
            if (xStr.charAt(i) != xStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
