package com.yang.practice.jianzhioffer.qa50firstonceletter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * TODO 需要练习
 *
 * @Author: yangguojun01
 * @Date: 2022/4/10
 */
public class FirstOnceLetter {

    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.containsKey(s.charAt(i)));
        }
        for (int i = 0; i < s.length(); i++) {
            if (!map.get(s.charAt(i))) {
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
