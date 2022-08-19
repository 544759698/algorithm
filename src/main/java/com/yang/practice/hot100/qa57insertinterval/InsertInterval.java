package com.yang.practice.hot100.qa57insertinterval;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/8/19
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            int[][] retArr = new int[1][];
            retArr[0] = newInterval;
            return retArr;
        }
        int firstIn = -1;
        int lastIn = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]) {
                firstIn = i;
            }
            if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1]) {
                lastIn = i;
            }
            if (firstIn != -1 && lastIn != -1) {
                break;
            }
        }
        List<int[]> ret = new ArrayList<int[]>();
        if (firstIn == -1 && lastIn == -1) {
            if (newInterval[0] < intervals[0][0] && newInterval[1] > intervals[intervals.length - 1][1]) {
                ret.add(newInterval);
            } else {
                if (newInterval[1] < intervals[0][0]) {
                    ret.add(newInterval);
                }
                for (int i = 0; i < intervals.length; i++) {
                    if (newInterval[0] < intervals[i][0] && newInterval[1] > intervals[i][1]) {
                        ret.add(newInterval);
                    } else if (i < intervals.length - 1 && intervals[i][1] < newInterval[0]
                            && intervals[i + 1][0] > newInterval[1]) {
                        ret.add(intervals[i]);
                        ret.add(newInterval);
                    } else {
                        ret.add(intervals[i]);
                    }
                }
                if (newInterval[0] > intervals[intervals.length - 1][1]) {
                    ret.add(newInterval);
                }
            }
        } else if (firstIn == -1 && lastIn != -1) {
            ret.add(new int[] {newInterval[0], intervals[lastIn][1]});
            for (int i = lastIn + 1; i < intervals.length; i++) {
                ret.add(intervals[i]);
            }
        } else if (firstIn != -1 && lastIn == -1) {
            for (int i = 0; i < firstIn; i++) {
                ret.add(intervals[i]);
            }
            ret.add(new int[] {intervals[firstIn][0], newInterval[1]});
            for (int i = firstIn + 1; i < intervals.length; i++) {
                if (intervals[i][0] > newInterval[1]) {
                    ret.add(intervals[i]);
                }
            }
        } else {
            for (int i = 0; i < firstIn; i++) {
                ret.add(intervals[i]);
            }
            ret.add(new int[] {intervals[firstIn][0], intervals[lastIn][1]});
            for (int i = lastIn + 1; i < intervals.length; i++) {
                ret.add(intervals[i]);
            }
        }
        int[][] retArr = new int[ret.size()][];
        for (int i = 0; i < ret.size(); i++) {
            retArr[i] = ret.get(i);
        }
        return retArr;
    }
}
