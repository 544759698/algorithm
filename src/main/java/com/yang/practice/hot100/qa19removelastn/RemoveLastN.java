package com.yang.practice.hot100.qa19removelastn;

/**
 * @Author: yangguojun01
 * @Date: 2022/9/5
 */
public class RemoveLastN {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode dump = pre;
        int idx = 0;
        while (head != null) {
            if (idx >= n) {
                pre = pre.next;
            }
            idx++;
            head = head.next;
        }
        if (pre.next != null) {
            pre.next = pre.next.next;
        }
        return dump.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
