package com.uin.nwxy.linkedlist;


import com.uin.leetcode_100.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * 对单链表进行排序
 *
 * @author wanglufei
 */
public class Main {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head.next, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //后半部分
        ListNode mid = slow.next;
        //前半部分
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left != null ? left : right;
        return res.next;
    }

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(6);
    }
}


