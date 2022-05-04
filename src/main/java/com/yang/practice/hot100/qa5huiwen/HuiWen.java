package com.yang.practice.hot100.qa5huiwen;

/**
 * TODO 待复习
 *
 * @Author: yangguojun01
 * @Date: 2022/2/19
 */
public class HuiWen {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLongest(i, i, s);
            int len2 = getLongest(i, i + 1, s);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                // 这里len-1通过画图总结得到，可看官方图解视频04:44
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getLongest(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // 倾向于填充法，容易理解

    public static void main(String[] args) {
        HuiWen h = new HuiWen();
        System.out.println(h.longestPalindrome("cbbd"));
    }

}
