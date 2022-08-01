package com.yang.practice.jianzhioffer.qa21oddeven;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/11
 */
public class OddEven {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < nums.length && isOdd(nums[i])) {
                i++;
            }
            while (j >= 0 && !isOdd(nums[j])) {
                j--;
            }
            if (j > i) {
                swap(nums, i, j);
            }
        }
        return nums;
    }

    // 这里不封装函数leetcode耗时会变成1ms，封装了变成3ms
    private boolean isOdd(int num) {
        //        return (num & 1) == 1;
        return num % 2 == 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
