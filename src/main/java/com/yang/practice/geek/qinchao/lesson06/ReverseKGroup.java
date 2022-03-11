package com.yang.practice.geek.qinchao.lesson06;

/**
 * TODO 不想做了
 * @Author: yangguojun01
 * @Date: 2022/3/9
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode start = head;
        ListNode end = head;
        ListNode newHead = head;
        for (int i = 0; i < k - 1; i++) {
            if (head != null) {
                head = head.next;
            } else {
                return newHead;
            }
        }
        end = head;


        return null;
    }

    private ListNode[] reverseBetween(ListNode start, ListNode end) {
        ListNode[] ret = new ListNode[2];
        ListNode pre = null;
        ListNode curr = start;
        while (curr != end) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return ret;
    }
}
