package com.yang.practice.hot100.qa22generatebracket;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/9/7
 */
public class GenerateBracket {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generateOne(ret, new StringBuilder(), n, n);
        return ret;
    }

    public void generateOne(List<String> ret, StringBuilder ans, int leftAvail, int rightAvail) {
        if (leftAvail == 0 && rightAvail == 0) {
            ret.add(ans.toString());
            return;
        }
        if (leftAvail > 0) {
            ans.append("(");
            generateOne(ret, ans, leftAvail - 1, rightAvail);
            ans.deleteCharAt(ans.length() - 1);
        }
        if (rightAvail > leftAvail && rightAvail > 0) {
            ans.append(")");
            generateOne(ret, ans, leftAvail, rightAvail - 1);
            ans.deleteCharAt(ans.length() - 1);
        }
    }
}
