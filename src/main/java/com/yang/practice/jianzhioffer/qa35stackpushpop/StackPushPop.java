package com.yang.practice.jianzhioffer.qa35stackpushpop;

import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/17
 */
public class StackPushPop {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
