package com.yang.practice.jianzhioffer.qa24reverselist;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/19
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
