package com.yang.practice.hot100.qa148sortlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: yangguojun01
 * @Date: 2022/4/3
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        while (head != null) {
            queue.offer(head);
            head = head.next;
        }
        ListNode newHead = queue.poll();
        ListNode curr = newHead;
        while (!queue.isEmpty()) {
            ListNode top = queue.poll();
            curr.next = top;
            top.next = null;
            curr = top;
        }
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
