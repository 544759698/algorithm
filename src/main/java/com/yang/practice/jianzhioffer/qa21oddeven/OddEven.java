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
            if (i < j && i < nums.length && j >= 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        return nums;
    }

    private boolean isOdd(int num) {
        return (num & 1) == 1;
    }

}
