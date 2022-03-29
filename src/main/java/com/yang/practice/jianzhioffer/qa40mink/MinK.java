package com.yang.practice.jianzhioffer.qa40mink;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/29
 */
public class MinK {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ret = new int[k];
        if (k == 0) {
            return ret;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int a : arr) {
            if (queue.size() < k) {
                queue.offer(a);
            } else if (a < queue.peek()) {
                queue.poll();
                queue.offer(a);
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            ret[i] = queue.poll();
            i++;
        }
        return ret;
    }
}
