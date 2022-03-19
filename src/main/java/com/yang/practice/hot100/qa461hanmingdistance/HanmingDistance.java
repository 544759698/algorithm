package com.yang.practice.hot100.qa461hanmingdistance;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/19
 */
public class HanmingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int ret = 0;
        while (z > 0) {
            z = z & (z - 1);
            ret++;
        }
        return ret;
    }
}
