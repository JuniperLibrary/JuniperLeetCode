package com.uin.level1.leetcode_206;

import com.uin.leetcode_100.linkedlist.ListNode;

public class Main {
    /**
     * 迭代
     *
     * @param head
     * @return com.uin.leetcode_100.linkedlist.ListNode
     * @author wanglufei
     * @date 2022/8/14 11:27 AM
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 递归
     *
     * @param head
     * @return com.uin.leetcode_100.linkedlist.ListNode
     * @author wanglufei
     * @date 2022/8/14 11:36 AM
     */
    public ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = helper(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
