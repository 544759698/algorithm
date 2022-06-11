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
        int[] ans = new int[temperatures.length];
        // 栈里存索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 新数据大于栈顶索引的元素，则栈顶索引元素第一个大于它的元素可以找到，同时弹出栈顶元素
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIdx = stack.pop();
                ans[preIdx] = i - preIdx;
            }
            stack.push(i);
        }
        return ans;
    }

}
