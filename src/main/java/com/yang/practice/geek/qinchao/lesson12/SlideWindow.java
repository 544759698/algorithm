package com.yang.practice.geek.qinchao.lesson12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: yangguojun01
 * @Date: 2021/12/29
 */
public class SlideWindow {

    // TODO 待复习

    public int[] getMaxSlideWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] ret = new int[nums.length - k + 1];
        // deque中存储数组元素下标，这样可以不判断deque长度
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 删除队列中小于窗口左边下标的元素
            if (i >= k && i - k + 1 > deque.peek()) {
                deque.remove();
            }
            // 从队列右侧开始, 删除小于nums[i] 的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.add(i);
            // 队列左侧是最大值,加入结果
            if (i - k + 1 >= 0) {
                ret[i - k + 1] = nums[deque.peek()];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, -1, 4, 5, 2, 1, 6, 9, 0};
        SlideWindow s = new SlideWindow();
        int[] ret = s.getMaxSlideWindow(nums, 3);
        for (int r : ret) {
            System.out.println(r);
        }
    }

}
