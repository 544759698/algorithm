package com.yang.practice.jianzhioffer.qa18deletenode;

/**
 * @Author: yangguojun01
 * @Date: 2022/2/18
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode dump = pre;
        while (head != null) {
            if (head.val == val) {
                ListNode tmp = head.next;
                pre.next = tmp;
                break;
            } else {
                head = head.next;
                pre = pre.next;
            }
        }
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
