package com.yang.practice.hot100.qa33searchsplitarray;

/**
 * TODO NEXT
 *
 * @Author: yangguojun01
 * @Date: 2022/3/1
 */
public class SearchSplitArray {
    public int search(int[] nums, int target) {
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }
        if (target == nums[0]) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int minIdx = left;
        int l = 0, r = 0;
        if (nums[nums.length - 1] > target) {
            l = minIdx;
            r = nums.length - 1;
        } else {
            l = 0;
            r = minIdx - 1;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        SearchSplitArray s = new SearchSplitArray();
        System.out.println(s.search(nums, 8));
    }

}
