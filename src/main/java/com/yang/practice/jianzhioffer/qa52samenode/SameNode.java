package com.yang.practice.jianzhioffer.qa52samenode;

import java.util.Stack;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/19
 */
public class SameNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ret = null;
        if (headA == null || headB == null) {
            return ret;
        }
        Stack<ListNode> sa = new Stack<>();
        Stack<ListNode> sb = new Stack<>();
        while (headA != null) {
            sa.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            sb.push(headB);
            headB = headB.next;
        }
        while (!sa.isEmpty() && !sb.isEmpty() && sa.peek() == sb.peek()) {
            ret = sa.pop();
            sb.pop();
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
