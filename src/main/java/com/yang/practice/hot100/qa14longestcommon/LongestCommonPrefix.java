package com.yang.practice.hot100.qa14longestcommon;

/**
 * TODO 看题解再优化
 *
 * @Author: yangguojun01
 * @Date: 2022/5/21
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int commonIdx = 0;
        String checkStr = strs[0];
        boolean isCommon = true;
        while (commonIdx < checkStr.length() && isCommon) {
            for (int i = 1; i < strs.length; i++) {
                char currChar = checkStr.charAt(commonIdx);
                if (commonIdx >= strs[i].length() || strs[i].charAt(commonIdx) != currChar) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon) {
                commonIdx++;
            }
        }
        return checkStr.substring(0, commonIdx);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "sflower"};
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(strs));
    }

}
