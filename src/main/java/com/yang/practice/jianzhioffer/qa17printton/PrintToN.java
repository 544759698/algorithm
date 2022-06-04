package com.yang.practice.jianzhioffer.qa17printton;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/18
 */
public class PrintToN {

    // TODO 不理解

    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers2(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }
    void dfs(int x) {
        if(x == n) { // 终止条件：已固定完所有位
            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }

    public int[] printNumbers1(int n) {
        int max = (int) Math.pow(10, n);
        int[] retArr = new int[max - 1];
        for (int i = 1; i < max; i++) {
            retArr[i - 1] = i;
        }
        return retArr;
    }

    public static void main(String[] args) {
        PrintToN p = new PrintToN();
        System.out.println(p.printNumbers2(2));
    }
}
