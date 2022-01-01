package com.yang.practice.geek.qinchao.lesson12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 返回滑动窗口最大值
 *
 * @Author: yangguojun01
 * @Date: 2021/12/29
 */
public class SlideWindow {

    // TODO 待复习

    public int[] getMaxSlideWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 保存结果
        int[] ret = new int[nums.length - k + 1];
        // 双端队列，deque中存储数组元素下标，这样可以不判断deque长度
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 1.删除队列中小于窗口左侧下标的元素 peek取队首元素但不删除 remove取队首元素并删除
            // 超过窗口长度的左侧元素先淘汰，保证deque长度不会超过k
            if (i >= k && i - k + 1 > deque.peek()) {
                deque.remove();
            }
            // 2.从队列右侧开始, 删除小于nums[i]的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            // 3.添加当前下标
            deque.add(i);
            // 4.队列左侧是最大值，因为超过窗口长度的在第1步中淘汰，比他小的在第2步中淘汰，加入结果
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