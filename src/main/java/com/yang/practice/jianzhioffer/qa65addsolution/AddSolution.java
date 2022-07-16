package com.yang.practice.jianzhioffer.qa65addsolution;

/**
 * @Author: yangguojun01
 * @Date: 2022/7/16
 */
public class AddSolution {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        AddSolution as = new AddSolution();
        System.out.println(as.add(20, 17));
    }

}
