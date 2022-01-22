package com.yang.practice.geek.qinchao.lesson09;

import java.util.Stack;

/**
 * leetcode 232 225 用栈实现队列
 *
 * @Author: yangguojun01
 * @Date: 2021/12/28
 */
public class StackToQueue {

    /***
     * 入队列的元素
     */
    Stack<Integer> input = new Stack<>();
    /***
     * 出队列的元素
     */
    Stack<Integer> output = new Stack<>();

    public void push(Integer x) {
        input.push(x);
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        // 出队列为空时才将入队列元素放到出队列
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }
}
