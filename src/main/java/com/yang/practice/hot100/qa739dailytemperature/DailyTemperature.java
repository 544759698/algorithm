package com.yang.practice.hot100.qa739dailytemperature;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/2
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
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
}
