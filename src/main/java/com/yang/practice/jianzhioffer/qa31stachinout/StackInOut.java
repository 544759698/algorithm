package com.yang.practice.jianzhioffer.qa31stachinout;

import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/6/11
 */
public class StackInOut {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int i = 0; i < pushed.length; i++) {
            // 这一段好像不需要
            while (!stack.isEmpty() && popped[popIdx] == stack.peek()) {
                stack.pop();
                popIdx++;
            }
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[popIdx] == stack.peek()) {
                stack.pop();
                popIdx++;
            }
        }
        return stack.isEmpty();
    }
}
