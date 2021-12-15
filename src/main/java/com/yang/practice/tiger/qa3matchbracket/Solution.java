package com.yang.practice.tiger.qa3matchbracket;

import java.util.Stack;

/**
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

    public static void main(String[] args) {
        String equation = "{{[[()]}}}";
        Solution s = new Solution();
        System.out.println(s.checkBrackets(equation));
    }

}
