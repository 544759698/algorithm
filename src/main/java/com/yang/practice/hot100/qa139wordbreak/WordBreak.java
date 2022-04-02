package com.yang.practice.hot100.qa139wordbreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/2
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<String>() {{
            add("apple");
            add("pen");
        }};
        System.out.println(w.wordBreak(s, wordDict));
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder(s);
        return chekWord(sb, wordDict, 0);
    }

    public boolean chekWord(StringBuilder sb, List<String> wordDict, int idx) {
        if (sb.length() == 0) {
            return true;
        }
        if (idx == wordDict.size() && sb.length() > 0) {
            return false;
        }
        String word = wordDict.get(idx);
        if (sb.indexOf(word) > -1) {
            int offset = sb.indexOf(word);
            sb = sb.replace(offset, word.length(), "");
            if (chekWord(sb, wordDict, idx + 1)) {
                return true;
            }
            sb = sb.insert(offset, word);
        } else {
            chekWord(sb, wordDict, idx + 1);
        }

        return false;
    }

}
