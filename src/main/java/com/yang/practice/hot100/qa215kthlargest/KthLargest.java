package com.yang.practice.hot100.qa215kthlargest;

import java.util.PriorityQueue;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/2
 */
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.offer(nums[i]);
            } else if (nums[i] > queue.peek() && queue.size() >= k) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
