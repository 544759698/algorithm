package com.yang.practice.hot100.qa21mergetwolist;

/**
 * @Author: yangguojun01
 * @Date: 2022/9/8
 */
public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(-1);
        ListNode dump = pre;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 != null ? list1 : list2;
        return dump.next;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(-1);
        ListNode dump = pre;
        while (list1 != null || list2 != null) {
            if ((list1 != null && list2 == null) || ((list1 != null && list2 != null) && list1.val < list2.val)) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
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
