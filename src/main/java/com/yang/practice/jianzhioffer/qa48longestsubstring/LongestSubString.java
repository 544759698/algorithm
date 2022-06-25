package com.yang.practice.jianzhioffer.qa48longestsubstring;

import java.util.HashMap;

/**
 * TODO 需要复习
 *
 * @Author: yangguojun01
 * @Date: 2022/6/19
 */
public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ret = 0;
        // 注意这里，i=0时，长度为1，即0-(-1)=1，所以left初始值为-1
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            ret = Math.max(ret, i - left);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "abba";
        LongestSubString l = new LongestSubString();
        System.out.println(l.lengthOfLongestSubstring(s));
    }
}
