package com.yang.practice.hot100.qa155minstack;

import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/28
 */
public class MinStack {

    Stack<Integer> eleStack;
    Stack<Integer> minStack;

    public MinStack() {
        eleStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        eleStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        eleStack.pop();
        minStack.pop();
    }

    public int top() {
        return eleStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
