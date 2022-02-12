package com.yang.practice.hot100.qa2twonumsum;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/13
 */
public class TwoNumSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(-1);
        ListNode dump = curr;
        int toAdd = 0;
        while (l1 != null || l2 != null) {
            int twoSum = toAdd + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            toAdd = twoSum >= 10 ? 1 : 0;
            curr.next = new ListNode(twoSum % 10);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (toAdd == 1) {
            curr.next = new ListNode(1);
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
