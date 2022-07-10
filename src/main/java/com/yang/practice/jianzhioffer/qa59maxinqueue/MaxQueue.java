package com.yang.practice.jianzhioffer.qa59maxinqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: yangguojun01
 * @Date: 2022/7/10
 */
public class MaxQueue {

    Deque<Integer> data;
    Deque<Integer> max;

    public MaxQueue() {
        data = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty()) {
            return -1;
        }
        return max.peekFirst();
    }

    public void push_back(int value) {
        while (!max.isEmpty() && max.peekLast() < value) {
            max.pollLast();
        }
        data.offerLast(value);
        max.offerLast(value);
    }

    public int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }
        int top = data.pollFirst();
        if (max.peekFirst() == top) {
            max.pollFirst();
        }
        return top;
    }

}
