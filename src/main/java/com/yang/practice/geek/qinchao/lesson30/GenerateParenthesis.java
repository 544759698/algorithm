package com.yang.practice.geek.qinchao.lesson30;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/1/6
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generateOneByOne("", n, n, ret);
        return ret;
    }

    public void generateOneByOne(String sub, int leftAvailable, int rightAvailable, List<String> ret) {
        if (leftAvailable == 0 && rightAvailable == 0) {
            ret.add(sub);
            return;
        }
        // 先用完(，再回溯
        if (leftAvailable > 0) {
            generateOneByOne(sub + "(", leftAvailable - 1, rightAvailable, ret);
        }
        // leftAvailable最小为0，rightAvailable必然大于0
        if (rightAvailable > leftAvailable) {
            generateOneByOne(sub + ")", leftAvailable, rightAvailable - 1, ret);
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
        List<String> ret = g.generateParenthesis(2);
        System.out.println(ret);
        System.out.println(ret.size());
    }

}
