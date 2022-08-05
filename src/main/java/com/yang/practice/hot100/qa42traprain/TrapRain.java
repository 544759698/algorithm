package com.yang.practice.hot100.qa42traprain;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/3
 */
public class TrapRain {
    public int trap(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    // 此时right指针已指到rightMax的位置，
                    // rightMax > leftMax且height[left] < height[right]，所以用leftMax - height[left]
                    area += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    area += rightMax - height[right];
                }
                right--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrapRain t = new TrapRain();
        System.out.println(t.trap(height));
    }

}
