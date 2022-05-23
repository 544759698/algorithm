package com.yang.practice.jianzhioffer.qa05replacespace;

/**
 * @Author: yangguojun01
 * @Date: 2022/5/23
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null || s == "" || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
