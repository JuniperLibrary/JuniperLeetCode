package com.uin.leetcode_100.linkedlist.leetcode_148;

import com.uin.leetcode_100.linkedlist.ListNode;


public class Main {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next=left;
                left=left.next;
            }else {
                h.next=right;
                right=right.next;
            }
            h=h.next;
        }
        h.next=left!=null?left:right;
        return res.next;
    }
}
