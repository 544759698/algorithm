package com.yang.practice.geek.qinchao.lesson09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode225 队列实现栈
 *
 * @Author: yangguojun01
 * @Date: 2022/2/4
 */
public class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // TODO queue重新插入
        int n = queue.size();
        queue.add(x);
        for (int i = 0; i < n; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        return queue.poll();
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
