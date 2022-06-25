package com.yang.practice.jianzhioffer.qa41middlefinder;

import java.util.PriorityQueue;

/**
 * TODO 需要练习
 * @Author: yangguojun01
 * @Date: 2022/6/15
 */
public class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        // 大顶堆，保留前半部分，>=一半元素
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        // 小顶堆，保留后半部分，==一半元素
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.size() != minHeap.size()) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size() == minHeap.size() ? (maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
    }
}
