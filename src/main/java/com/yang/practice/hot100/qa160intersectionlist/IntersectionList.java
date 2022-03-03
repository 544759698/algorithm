package com.yang.practice.hot100.qa160intersectionlist;

import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/3
 */
public class IntersectionList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode ret = null;
        while (headA != null) {
            s1.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            s2.push(headB);
            headB = headB.next;
        }
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode l1 = s1.pop();
            ListNode l2 = s2.pop();
            if (l1 == l2) {
                ret = l1;
            } else {
                break;
            }
        }
        return ret;
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
