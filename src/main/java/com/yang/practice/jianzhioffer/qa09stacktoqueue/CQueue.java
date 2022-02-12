package com.yang.practice.jianzhioffer.qa09stacktoqueue;

import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/12
 */
public class CQueue {

    Stack<Integer> in, out;

    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (in.isEmpty() && out.isEmpty()) {
            return -1;
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}
