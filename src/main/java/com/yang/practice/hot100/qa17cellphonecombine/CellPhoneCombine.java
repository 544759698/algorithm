package com.yang.practice.hot100.qa17cellphonecombine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO 未完成
 *
 * @Author: yangguojun01
 * @Date: 2022/2/18
 */
public class CellPhoneCombine {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        HashMap<Character, char[]> dict = new HashMap<>();
        dict.put('2', new char[] {'a', 'b', 'c'});
        dict.put('3', new char[] {'d', 'e', 'f'});
        dict.put('4', new char[] {'g', 'h', 'i'});
        dict.put('5', new char[] {'j', 'k', 'l'});
        dict.put('6', new char[] {'m', 'n', 'o'});
        dict.put('7', new char[] {'p', 'q', 'r', 's'});
        dict.put('8', new char[] {'t', 'u', 'v'});
        dict.put('9', new char[] {'w', 'x', 'y', 'z'});
        for (int i = 0; i < digits.length(); i++) {

        }
        return ret;
    }

}
