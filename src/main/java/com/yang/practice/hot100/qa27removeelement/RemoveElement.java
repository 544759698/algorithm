package com.yang.practice.hot100.qa27removeelement;

/**
 * @Author: yangguojun01
 * @Date: 2022/8/10
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    public int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == val) {
                while (nums[right] == val && right > left) {
                    right--;
                }
                if (nums[right] != val) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                    right--;
                }
            } else {
                left++;
            }
        }
        return nums[left] == val ? left : left + 1;
    }
}
