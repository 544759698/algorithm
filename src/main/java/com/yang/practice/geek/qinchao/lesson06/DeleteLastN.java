package com.yang.practice.geek.qinchao.lesson06;

/**
 * leetcode19 删除倒数第N个节点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * TODO 待复习，注意实现细节
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class DeleteLastN {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 细节1
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 细节2
        second.next = second.next.next;
        // 细节3
        return dummy.next;
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
