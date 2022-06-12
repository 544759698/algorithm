package com.yang.practice.jianzhioffer.qa38stringpailie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/6/12
 */
public class StringPailie {

    List<String> ret = new ArrayList<>();
    boolean[] visited;

    public String[] permutation(String s) {
        visited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        trackback(chars, 0, sb);
        String[] strArr = new String[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            strArr[i] = ret.get(i);
        }
        return strArr;
    }

    public void trackback(char[] chars, int i, StringBuilder sb) {
        if (i == chars.length) {
            ret.add(sb.toString());
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if (visited[j] || (j > 0 && !visited[j - 1] && chars[j] == chars[j - 1])) {
                continue;
            }
            visited[j] = true;
            sb.append(chars[j]);
            trackback(chars, i + 1, sb);
            visited[j] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
