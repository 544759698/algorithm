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
    
}
