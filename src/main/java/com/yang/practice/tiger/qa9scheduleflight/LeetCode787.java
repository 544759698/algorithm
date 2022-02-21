package com.yang.practice.tiger.qa9scheduleflight;

import java.util.PriorityQueue;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/21
 */
public class LeetCode787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        // price,city,k
        queue.add(new int[] {0, src, k + 1});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) {
                return price;
            }
            if (stops > 0) {
                for (int i = 0; i < flights.length; i++) {
                    if (flights[i][0] == city) {
                        queue.add(new int[] {price + flights[i][2], flights[i][1], stops - 1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode787 l = new LeetCode787();
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(l.findCheapestPrice(3, flights, 0, 2, 1));
    }

}
