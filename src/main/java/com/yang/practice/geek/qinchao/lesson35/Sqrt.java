package com.yang.practice.geek.qinchao.lesson35;

/**
 * leetcode69 求平方根
 *
 * @Author: yangguojun01
 * @Date: 2022/1/7
 */
public class Sqrt {

    public int mySqrt(int x) {
        double ans = 0;
        double left = 0;
        double right = x;
        while ((right - left) > 0.00000001) {
            double mid = left + (right - left) / 2;
            ans = mid;
            // 可以防止越界
            if (mid > x / mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(ans);
        return (int) right;
        //        return (int) (left + right) / 2;
    }

    public static void main(String[] args) {
        Sqrt s = new Sqrt();
        System.out.println(s.mySqrt(36));
    }
}

class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

