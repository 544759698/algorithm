package com.yang.practice.hot100.qa142circlelist;

import java.util.HashSet;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/4
 */
public class CircleList {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}