package com.yang.practice.hot100.qa32longestparentheses;

import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/8/14
 */
public class LongestParentheses {
    public int longestValidParentheses(String s) {
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        // 有个兜底元素，便于处理索引边界问题
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 如果一直是)，不停的弹出，压入，最后总有一个兜底的断点
                stack.pop();
                if (!stack.isEmpty()) {
                    ret = Math.max(ret, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return ret;
    }
}
