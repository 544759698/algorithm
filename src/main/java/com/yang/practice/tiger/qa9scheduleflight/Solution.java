package com.yang.practice.tiger.qa9scheduleflight;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: yangguojun01
 * @Date: 2021/12/22
 */
public class Solution {

    // TODO:待复习

    public int scheduleFlights(int[][][] flights, int from, int to, int k) {
        // 使用优先队列，小顶堆
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // 价格，出发城市，经停次数（最小值为0，下面判断条件是>0，所以+1）
        queue.add(new int[] {0, from, k + 1});
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == to) {
                return price;
            }
            if (stops > 0) {
                for (int i = 0; i < flights[city].length; i++) {
                    queue.add(new int[] {price + flights[city][i][1], flights[city][i][0], stops - 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][][] flights = {{{1, 1000}, {2, 2000}}, {{2, 500}}, {{1, 500}}};
        Solution s = new Solution();
        System.out.println(s.scheduleFlights(flights, 0, 2, 1));
    }

}
