package com.yang.practice.tiger.qa8schedulecourse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: yangguojun01
 * @Date: 2021/12/21
 */
public class Solution {

    // TODO:待复习

    public boolean scheduleCourse(int[][] preRequires) {
        // 每节课的前置课数量，入度
        int[] degree = new int[preRequires.length];
        // 前置课上完后可以上的课的列表 id:前置课 list:可以上的课
        List<Integer>[] neighbors = new ArrayList[preRequires.length];
        Queue<Integer> available = new LinkedList<>();

        for (int id = 0; id < preRequires.length; id++) {
            neighbors[id] = new ArrayList<>();
            // 每节课的前置课数量，入度
            degree[id] = preRequires[id].length;
            if (degree[id] == 0) {
                available.offer(id);
            }
        }

        // from:要上的课     to:前置课
        // 前置课上完后可以上的课的列表 id:前置课 list:可以上的课
        for (int from = 0; from < preRequires.length; from++) {
            for (int to : preRequires[from]) {
                neighbors[to].add(from);
            }
        }

        int count = 0;
        while (!available.isEmpty()) {
            // 上课的顺序
            System.out.println(available.peek());
            for (int id : neighbors[available.poll()]) {
                degree[id]--;
                if (degree[id] == 0) {
                    available.offer(id);
                }
            }
            count++;
        }

        return count == preRequires.length;
    }

    public static void main(String[] args) {
        int[][] preRequires = {{1}, {3}, {3}, {}};
        //        int[][] preRequires = {{1}, {0}, {}};
        Solution s = new Solution();
        System.out.println(s.scheduleCourse(preRequires));
    }

}
