package com.yang.practice.geek.qinchao.lesson06;

/**
 * 删除倒数第N个节点
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class DeleteLastN {

    public ListNode deleteLastN(ListNode head, int n) {
        int i = 0;
        ListNode fast = head;
        while (i < n && fast != null) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            return null;
        }
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) {
            prev.next = prev.next.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        DeleteLastN d = new DeleteLastN();
        ListNode listNode = d.deleteLastN(listNode1, 3);
        System.out.println(listNode.value);
    }
}
