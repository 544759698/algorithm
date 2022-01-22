package com.yang.practice.geek.qinchao.lesson06;

/**
 * leetcode19 删除倒数第N个节点
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class DeleteLastN {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode beforeN = new ListNode(-1);
        ListNode dumpy = beforeN;
        beforeN.next = head;
        int i = 0;
        while (head != null) {
            i++;
            if (i > n) {
                beforeN = beforeN.next;
            }
            head = head.next;
        }
        beforeN.next = beforeN.next.next;
        return dumpy.next;
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
        ListNode listNode = d.removeNthFromEnd(listNode1, 3);
        System.out.println(listNode.val);
    }
}
