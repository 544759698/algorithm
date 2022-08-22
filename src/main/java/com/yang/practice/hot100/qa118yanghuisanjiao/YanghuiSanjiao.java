package com.yang.practice.hot100.qa118yanghuisanjiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/8/22
 */
public class YanghuiSanjiao {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i ) {
                    item.add(1);
                } else {
                    item.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(item);
        }
        return ret;
    }

}
