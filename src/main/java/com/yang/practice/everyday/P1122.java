package com.yang.practice.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;

/**
 * @Author: yangguojun01
 * @Date: 2020/11/22
 */
public class P1122 {

    public static void main(String[] args) {
        //System.out.println(translateNum("十万九千零六十"));
        //        System.out.println(translateNum("一亿三千零五万九千零六十"));
        String translateStr = "一亿三千零五万九千零六十";
        List<String> splitStrs = splitBySeniorUnit(translateStr);
        long sum = 0L;
        for (String s : splitStrs) {
            long tmp = translateNum(s);
            sum += tmp;
        }
        System.out.println(sum);
    }

    public static List<String> splitBySeniorUnit(String translateStr) {
        List<String> ret = new ArrayList<>();
        int firstIndex = translateStr.indexOf("亿");
        if (firstIndex > -1) {
            ret.add(translateStr.substring(0, firstIndex + 1));
            translateStr = translateStr.substring(firstIndex + 1);
        }
        int secondIndex = translateStr.indexOf("万");
        if (secondIndex > -1) {
            ret.add(translateStr.substring(0, secondIndex + 1));
            translateStr = translateStr.substring(secondIndex + 1);
        }
        if (StringUtils.isNotEmpty(translateStr)) {
            ret.add(translateStr);
        }
        return ret;
    }

    public static Long translateNum(String chineseNum) {
        if (StringUtils.isEmpty(chineseNum)) {
            return 0L;
        }
        String lastUnit = "";
        if (chineseNum.endsWith("亿") || chineseNum.endsWith("万")) {
            lastUnit = chineseNum.substring(chineseNum.length() - 1);
        }
        String numsStr = "一二三四五六七八九";
        String unitsStr = "十百千";
        Stack<Long> stack = new Stack<>();
        String[] chineseNums = chineseNum.split("");
        for (String numStr : chineseNums) {
            int numIndex = numsStr.indexOf(numStr);
            int unitIndex = unitsStr.indexOf(numStr);
            if (numIndex != -1) {
                stack.push((long) numIndex + 1);
            } else if (unitIndex != -1) {
                double unitNum = Math.pow(10, unitIndex + 1);
                if (!stack.isEmpty()) {
                    stack.push((long) (stack.pop() * unitNum));
                } else {
                    stack.push((long) unitNum);
                }
            }
        }
        long sum = stack.stream().mapToLong(s -> s).sum();
        if ("亿".equals(lastUnit)) {
            return sum * 100000000;
        }
        if ("万".equals(lastUnit)) {
            return sum * 10000;
        }
        return sum;
    }

}
