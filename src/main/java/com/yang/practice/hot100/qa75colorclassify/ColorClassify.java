package com.yang.practice.hot100.qa75colorclassify;

import java.util.HashMap;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/26
 */
public class ColorClassify {
    public void sortColors(int[] nums) {
        int currIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int tmp = nums[currIdx];
                nums[currIdx] = nums[i];
                nums[i] = tmp;
                currIdx++;
            }
        }
        for (int i = currIdx; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[currIdx];
                nums[currIdx] = nums[i];
                nums[i] = tmp;
                currIdx++;
            }
        }
    }

    public void sortColors1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < map.get(0); i++) {
            nums[i] = 0;
        }
        for (int i = map.get(0); i < (map.get(0) + map.get(1)); i++) {
            nums[i] = 1;
        }
        for (int i = map.get(0) + map.get(1); i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        ColorClassify c = new ColorClassify();
        c.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
