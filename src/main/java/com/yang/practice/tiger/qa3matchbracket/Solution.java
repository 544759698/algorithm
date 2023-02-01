package com.yang.practice.tiger.qa3matchbracket;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * @Author: yangguojun01
 * @Date: 2021/12/13
 */
public class Solution {

    public boolean checkBrackets(String equation) {
        Stack<Character> stack = new Stack<>();
        for (char c : equation.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop()) {
                        return false;
                    }
                    break;
            }
        }
        return stack.size() == 0;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(map.get(s.charAt(i)));
            } else {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String equation = "{{[[()]}}}";
        Solution s = new Solution();
        System.out.println(s.checkBrackets(equation));
    }

}
