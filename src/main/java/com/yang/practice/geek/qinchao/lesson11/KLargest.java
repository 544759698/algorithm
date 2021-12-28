package com.yang.practice.geek.qinchao.lesson11;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 获取第K大的数字
 *
 * @Author: yangguojun01
 * @Date: 2021/12/28
 */
public class KLargest {

    public int getKLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.offer(nums[i]);
            } else if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 8, 1, 2, 5, 3};
        KLargest kLargest = new KLargest();
        System.out.println(kLargest.getKLargest(nums, 3));
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
