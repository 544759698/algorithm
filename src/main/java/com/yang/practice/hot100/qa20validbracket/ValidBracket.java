package com.yang.practice.hot100.qa20validbracket;

import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/9/6
 */
public class ValidBracket {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || s.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
