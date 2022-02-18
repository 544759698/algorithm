package com.yang.practice.jianzhioffer.qa22lastknode;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/19
 */
public class LastKNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int i = 0;
        ListNode preKNode = head;
        while (head != null && i < k) {
            head = head.next;
            i++;
        }
        while (head != null) {
            head = head.next;
            preKNode = preKNode.next;
        }
        return preKNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}