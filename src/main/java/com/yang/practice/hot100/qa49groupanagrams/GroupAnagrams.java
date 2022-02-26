package com.yang.practice.hot100.qa49groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/26
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> charMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                charMap.put(str.charAt(i), charMap.getOrDefault(str.charAt(i), 0) + 1);
            }
            List<String> sameList = map.get(charMap);
            if (sameList == null) {
                map.put(charMap, new ArrayList<String>() {{
                    add(str);
                }});
            } else {
                sameList.add(str);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
