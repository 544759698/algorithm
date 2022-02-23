package com.yang.practice.geek.qinchao.lesson06;

/**
 * leetcode24 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 如：给定 1->2->3->4, 应该返回 2->1->4->3.
 * TODO 待复习
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class SwapTwoNodes {

    public ListNode swapTwoNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            head.next = n2;
            // 下面两步必须此顺序，否则n2.next变了后再把n1.next指向n2.next就不对了
            n1.next = n2.next;
            n2.next = n1;
            head = n1;
        }
        return dummy.next;
    }

    // 自己写的，好理解的
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode dump = pre;
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null) {
            ListNode tmp = second.next;
            pre.next = second;
            second.next = first;
            first.next = tmp;
            pre = first;
            first = tmp;
            second = tmp == null ? null : tmp.next;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        SwapTwoNodes s = new SwapTwoNodes();
        ListNode newHead = s.swapTwoNodes(listNode1);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

}
