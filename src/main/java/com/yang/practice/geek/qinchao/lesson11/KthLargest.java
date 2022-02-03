package com.yang.practice.geek.qinchao.lesson11;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode703 获取第K大的数字
 *
 * @Author: yangguojun01
 * @Date: 2021/12/28
 */
public class KthLargest {

    PriorityQueue<Integer> queue;
    int capacity;

    public KthLargest(int k, int[] nums) {
        // initialCapacity只是初始容量，超过会再增长
        queue = new PriorityQueue<>();
        capacity = k;
        for (int i = 0; i < nums.length; i++) {
            // 这里调用自己类的add方法，不用queue的
            this.add(nums[i]);
        }
    }

    public int add(int val) {
        // 先添加再判断长度，代码相比先判断后添加简洁些
        queue.offer(val);
        if (queue.size() > capacity) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 8, 1, 2, 5, 3};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));
    }

    /***
     * Java 大顶堆实现
     */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

}
