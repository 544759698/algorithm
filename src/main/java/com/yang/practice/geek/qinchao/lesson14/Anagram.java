package com.yang.practice.geek.qinchao.lesson14;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

/**
 * 有效的字母异位词 eg:tar rat
 *
 * @Author: yangguojun01
 * @Date: 2021/12/30
 */
public class Anagram {

    public boolean isAnagram(String v1, String v2) {
        if (StringUtils.isEmpty(v1) || StringUtils.isEmpty(v2) || v1.length() != v2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        char[] chars1 = v1.toCharArray();
        char[] chars2 = v2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            map1.put(chars1[i], map1.getOrDefault(chars1[i], 0) + 1);
            map2.put(chars2[i], map2.getOrDefault(chars2[i], 0) + 1);
        }
        return map1.equals(map2);
    }

    public static void main(String[] args) {
        Anagram a = new Anagram();
        System.out.println(a.isAnagram("tarttuuyt", "ratuuytt"));
    }

}
