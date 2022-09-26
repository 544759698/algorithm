package com.yang.practice.hot100.qa11maxarea;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/28
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea m = new MaxArea();
        System.out.println(m.maxArea(height));
    }

}
