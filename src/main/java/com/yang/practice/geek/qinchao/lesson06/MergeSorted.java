package com.yang.practice.geek.qinchao.lesson06;

/**
 * leetcode21 合并两个有序链表
 *
 * @Author: yangguojun01
 * @Date: 2021/12/27
 */
public class MergeSorted {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 添加一个哨兵节点，省很多代码
        ListNode prev = new ListNode(-1);
        ListNode dummy = prev;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 != null ? list1 : list2;
        return dummy.next;
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
        ListNode listNode = m.mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode.val);
    }
}
