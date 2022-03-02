package com.yang.practice.hot100.qa739dailytemperature;

import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/2
 */
public class DailyTemperature {

    public int[] dailyTemperatures1(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int j = i + 1;
            while (j < temperatures.length) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
                j++;
            }
            if (j >= temperatures.length) {
                ans[i] = 0;
            }
        }
        return ans;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}
