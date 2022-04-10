package com.yang.practice.jianzhioffer.qa50firstonceletter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/10
 */
public class FirstOnceLetter {

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public char firstUniqChar1(String s) {
        List<Character> list = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            if (set.contains(curr)) {
                list.remove(curr);
            } else {
                set.add(curr);
                list.add(curr);
            }
        }
        return list.size() == 0 ? ' ' : list.get(0);
    }
}
