package com.yang.practice.hot100.qa4midinarrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/27
 */
public class MidInArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int queueLength = (nums1.length + nums2.length) / 2 + 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        fillQueue(queueLength, queue, nums1);
        fillQueue(queueLength, queue, nums2);
        if ((nums1.length + nums2.length) % 2 == 1) {
            return queue.peek();
        } else {
            return (queue.poll() + queue.poll()) / 2.0;
        }
    }

    public void fillQueue(int queueLength, PriorityQueue<Integer> queue, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < queueLength) {
                queue.offer(nums[i]);
            } else if (nums[i] < queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        MidInArrays m = new MidInArrays();
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }

}
