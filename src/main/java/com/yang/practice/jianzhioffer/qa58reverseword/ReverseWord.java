package com.yang.practice.jianzhioffer.qa58reverseword;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/20
 */
public class ReverseWord {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i] != "") {
                sb.append(words[i] + " ");
            }
        }
        return sb.toString().trim();
    }
}
