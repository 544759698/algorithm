package com.yang.practice.geek.qinchao.lesson06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode23 合并K个升序链表
 *
 * @Author: yangguojun01
 * @Date: 2022/1/24
 */
public class MergeKSortedLinkedList {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        // 添加一个哨兵节点
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;
        while (!queue.isEmpty()) {
            ListNode top = queue.poll();
            curr.next = top;
            curr = curr.next;
            if (top.next != null) {
                queue.add(top.next);
            }
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[1];
        lists[0] = new ListNode(1);
        MergeKSortedLinkedList m = new MergeKSortedLinkedList();
        ListNode head = m.mergeKLists(lists);
        System.out.println(head);
        System.out.println();
    }

}
