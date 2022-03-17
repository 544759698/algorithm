package com.yang.practice.hot100.qa234palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguojun01
 * @Date: 2022/3/17
 */
public class Palindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null && fast.next == null) {
            slow = slow.next;
        }
        ListNode halfHead = reverseList(slow);
        while (halfHead != null) {
            if (head.val != halfHead.val) {
                return false;
            }
            head = head.next;
            halfHead = halfHead.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;
    }

    public boolean isPalindrome1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (j - i > 0) {
            if (list.get(i).val != list.get(j).val) {
                return false;
            }
            i++;
            j--;
        }
        return true;
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
