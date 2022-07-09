package com.yang.practice.jianzhioffer.qa58reverseword;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/20
 */
public class ReverseWord {

    // 双指针 内存占用小 速度慢
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //String[] words = s.trim().split(" "); //这种split会把多个空格的也拆出一个空格来
        String[] words = s.trim().split("\\s+");
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String word = words[left];
            words[left] = words[right];
            words[right] = word;
            left++;
            right--;
        }
        return String.join(" ", words);
    }

    // 速度快一点
    public String reverseWords1(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i] != "") {
                sb.append(words[i] + " ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        ReverseWord r = new ReverseWord();
        System.out.println(r.reverseWords(s));
    }

}
