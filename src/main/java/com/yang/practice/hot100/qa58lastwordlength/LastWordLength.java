package com.yang.practice.hot100.qa58lastwordlength;

/**
 * @Author: yangguojun01
 * @Date: 2022/8/27
 */
public class LastWordLength {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
