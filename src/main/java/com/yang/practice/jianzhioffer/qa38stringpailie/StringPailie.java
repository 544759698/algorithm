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
            /***
             *  s[j-1]==s[j]即表示两个字符chr是相等的；
             *  若vis[j-1]为true表示新字符串的前面位置使用了s[j-1],即s[j-1]同s[j]不会出现在相同位置中,chr可再出现,s[j]可使用;
             *  vis[j-1]为false表示，相同字符chr未使用，相同字符避免重复都使用第一个出现该字符的下标数组值即s[j-1]。
             *  所以两字符相同，且前方s[j-1]未出现时，s[j]不可使用。
             *
             * 简单说明：字符串相同位置使用相同字符，为避免重复必定使用第一个出现的该字符的下标
             */
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
