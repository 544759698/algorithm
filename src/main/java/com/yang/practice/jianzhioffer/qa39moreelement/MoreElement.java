package com.yang.practice.jianzhioffer.qa39moreelement;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/9
 */
public class MoreElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = 0;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
            }
            count += num == ans ? 1 : -1;
        }
        return ans;
    }
}
