package com.yang.practice.everyday;

import org.apache.commons.lang.StringUtils;

/**
 * @Author: yangguojun01
 * @Date: 2020/11/4
 */
public class P1104 {

    public String replaceBlank(String input) {
        if (StringUtils.isEmpty(input)) {
            return StringUtils.EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P1104().replaceBlank("We are happy"));
    }

}
