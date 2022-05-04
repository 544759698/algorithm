package com.yang.practice.hot100.qa10reg;

/**
 * TODO dp 先略过
 *
 * @Author: yangguojun01
 * @Date: 2022/3/3
 */
public class Reg {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int pStart = 0;
        while (pStart < p.length()) {
            if (p.charAt(pStart) == s.charAt(i) || p.charAt(pStart) == '.') {
                j = pStart;
                break;
            }
            pStart++;
        }
        while (i < s.length() && j < p.length()) {
            if (j < p.length() - 1 && p.charAt(j) == '.' && p.charAt(j + 1) == '*') {
                i = i + 2;
                j = j + 2;
                if (i >= s.length() || j >= p.length()) {
                    break;
                }
            }
            if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.' && p.charAt(j) != '*') {
                return false;
            } else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                i++;
                j++;
            } else if (p.charAt(j) == '*' && j > 0 && s.charAt(i) == p.charAt(j - 1)) {
                int k = i + 1;
                while (k < s.length() && s.charAt(i) == s.charAt(k)) {
                    k++;
                }
                i = k;
                j++;
                while (j < p.length() && p.charAt(j) == p.charAt(j - 2)) {
                    j++;
                }
            } else {
                return false;
            }
        }
        if (i < s.length() || j < p.length()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Reg r = new Reg();
        System.out.println(r.isMatch("aaa", "a*a"));
    }
}
