package com.yang.practice.geek.qinchao.lesson30;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 待复习
 * leetcode22 数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 * https://leetcode.cn/problems/generate-parentheses/
 *
 * @Author: yangguojun01
 * @Date: 2022/1/6
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generateOne(ret, n, n, new StringBuilder());
        return ret;
    }

    public void generateOne(List<String> ret, int leftAvail, int rightAvail, StringBuilder sb) {
        if (leftAvail == 0 && rightAvail == 0) {
            ret.add(sb.toString());
            return;
        }
        if (leftAvail > 0) {
            sb.append("(");
            generateOne(ret, leftAvail - 1, rightAvail, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightAvail > leftAvail) {
            sb.append(")");
            generateOne(ret, leftAvail, rightAvail - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis1(int n) {
        List<String> ret = new ArrayList<>();
        generateOneByOne("", n, n, ret);
        return ret;
    }

    public void generateOneByOne(String sub, int leftAvailable, int rightAvailable, List<String> ret) {
        if (leftAvailable == 0 && rightAvailable == 0) {
            ret.add(sub);
        }
        // 先用完(，再回溯
        if (leftAvailable > 0) {
            sub = sub + "(";
            generateOneByOne(sub, leftAvailable - 1, rightAvailable, ret);
            sub = sub.substring(0, sub.length() - 1);
        }
        // leftAvailable最小为0，rightAvailable必然大于0，否则必然不合法
        if (rightAvailable > leftAvailable) {
            sub = sub + ")";
            generateOneByOne(sub, leftAvailable, rightAvailable - 1, ret);
            sub = sub.substring(0, sub.length() - 1);
        }
    }

    /***
     * 问：比如两队括号，执行完以后生成了(())后递归结束了，为什么还会进行递归操作，生成后面的()()？
     * 第一次递归完成不是return ，程序应该返回值了
     * 答：还会继续回到上一层递归调用的函数里，把接下来的语句执行完。
     * 第一个括号位相当于一层，每层有两个括号的选择。所以肯定后续 ()() 也会被递归到。
     * 第一层敲定为(后，因为第二层满足两个if条件，第一个分支走((，第二个分支走()，所以能递归到所有结果
     */

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> ret = g.generateParenthesis(5);
        System.out.println(ret);
        System.out.println(ret.size());
    }

}
