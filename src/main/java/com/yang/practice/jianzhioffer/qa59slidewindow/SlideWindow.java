package com.yang.practice.jianzhioffer.qa59slidewindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: yangguojun01
 * @Date: 2022/7/10
 */
public class SlideWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] ret = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && (i - queue.peekFirst()) >= k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.add(i);
            if (i + 1 - k >= 0) {
                ret[i + 1 - k] = nums[queue.peekFirst()];
            }
        }
        return ret;
    }

}
