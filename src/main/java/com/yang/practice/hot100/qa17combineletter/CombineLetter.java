package com.yang.practice.hot100.qa17combineletter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/22
 */
public class CombineLetter {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ret;
        }
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        fillLetter(0, digits, ret, new StringBuilder(), map);
        return ret;
    }

    public void fillLetter(int idx, String digits, List<String> ret, StringBuilder sb, HashMap<Character, char[]> map) {
        if (idx == digits.length()) {
            ret.add(sb.toString());
        } else {
            char[] charArr = map.get(digits.charAt(idx));
            for (int i = 0; i < charArr.length; i++) {
                sb.append(map.get(digits.charAt(idx))[i]);
                fillLetter(idx + 1, digits, ret, sb, map);
                sb.deleteCharAt(idx);
            }
        }
    }

}
