package com.yang.practice.hot100.qa35searchinsert;

/**
 * @Author: yangguojun01
 * @Date: 2022/8/9
 */
public class SearchInsert {

    // 标准二分法解法即可
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        SearchInsert si = new SearchInsert();
        System.out.println(si.searchInsert(nums, 0));
    }

}
