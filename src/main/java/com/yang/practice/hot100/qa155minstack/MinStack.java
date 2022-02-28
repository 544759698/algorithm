package com.yang.practice.hot100.qa155minstack;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/28
 */
public class MinStack {

    private PriorityQueue<Integer> queue = null;
    private Stack<Integer> stack = null;

    public MinStack() {
        queue = new PriorityQueue<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        queue.offer(val);
        stack.push(val);
    }

    public void pop() {
        int top = stack.pop();
        queue.remove(top);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }

}
