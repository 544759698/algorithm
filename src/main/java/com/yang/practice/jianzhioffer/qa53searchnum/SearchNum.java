package com.yang.practice.jianzhioffer.qa53searchnum;

/**
 * 二分查找及其变种问题（有部分if语句可以合并）
 *
 * @Author: yangguojun01
 * @Date: 2022/3/23
 */
public class SearchNum {

    public int search(int[] nums, int target) {
        int ret = 0;
        int left = 0;
        int right = nums.length - 1;
        // 寻找左边界
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (mid > 0 && nums[mid - 1] == target) {
                right = mid - 1;
            } else {
                left = mid;
                right = mid;
            }
        }
        for (int i = left; i < nums.length; i++) {
            if (nums[i] == target) {
                ret++;
            } else {
                break;
            }
        }
        return ret;
    }

    public int search1(int[] nums, int target) {
        int ret = 0;
        int left = 0;
        int right = nums.length - 1;
        // 寻找右边界
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (mid < nums.length - 1 && nums[mid + 1] == target) {
                left = mid + 1;
            } else {
                left = mid;
                right = mid;
            }
        }
        for (int i = right; i >= 0; i--) {
            if (nums[i] == target) {
                ret++;
            } else {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        SearchNum s = new SearchNum();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int ret = s.search(nums, 8);
        System.out.println(ret);
    }

}
