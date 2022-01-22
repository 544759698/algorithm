package com.yang.practice.geek.qinchao.lesson06;

/**
 * leetcode876 求链表的中间结点
 * 偶数个节点时返回中间一对后面的节点
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class MidNode {

    public ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        // 判断是否为偶数个节点，偶数个节点返回null
        //        return fast != null && fast.next == null ? slow : null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        MidNode m = new MidNode();
        ListNode listNode = m.findMidNode(listNode1);
        System.out.println(listNode == null ? "null" : listNode.value);
    }
}
