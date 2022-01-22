package com.yang.practice.geek.qinchao.lesson06;

/**
 * 合并两个有序链表
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class MergeSorted {

    public ListNode mergeSorted(ListNode left, ListNode right) {

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ListNode head;
        if (left.value < right.value) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }
        ListNode p = head;
        while (left != null && right != null) {
            if (left.value < right.value) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left != null) {
            p.next = left;
        } else {
            p.next = right;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        listNode1.next = listNode3;
        listNode2.next = listNode4;
        listNode3.next = listNode5;
        listNode4.next = listNode6;
        listNode5.next = listNode7;
        listNode6.next = listNode8;
        listNode7.next = listNode9;
        MergeSorted m = new MergeSorted();
        ListNode listNode = m.mergeSorted(listNode1, listNode2);
        System.out.println(listNode.value);
    }
}
