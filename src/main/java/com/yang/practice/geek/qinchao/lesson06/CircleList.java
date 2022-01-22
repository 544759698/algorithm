package com.yang.practice.geek.qinchao.lesson06;

/**
 * leetcode141 判断链表是否有环
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class CircleList {

    public boolean hasCircle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 判断条件看下面的语句里有哪些为空的情况
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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
        CircleList c = new CircleList();
        System.out.println(c.hasCircle(listNode1));
    }

}

