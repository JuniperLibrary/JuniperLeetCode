package com.uin.level.leetcode_19;

import com.uin.leetcode_100.linkedlist.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Main {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        //  快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        /**
        while (n>0){
            fast=fast.next;
            n--;
        }*/
        //conner case
        if (fast==null) return head.next;
        // 再同时走一步
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
