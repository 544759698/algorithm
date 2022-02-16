package com.yang.practice.jianzhioffer.qa06printlist;

import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/16
 */
public class PrintList {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ret = new int[stack.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
