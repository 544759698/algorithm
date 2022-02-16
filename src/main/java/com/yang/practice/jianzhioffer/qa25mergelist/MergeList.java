package com.yang.practice.jianzhioffer.qa25mergelist;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/16
 */
public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode dump = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                preHead.next = l1;
                l1 = l1.next;
            } else {
                preHead.next = l2;
                l2 = l2.next;
            }
            preHead = preHead.next;
        }
        preHead.next = l1 != null ? l1 : l2;
        return dump.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
