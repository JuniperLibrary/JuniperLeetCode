package com.uin.leetcode_100.linkedlist.jz_24;

import com.uin.leetcode_100.linkedlist.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Main {
    /**
     * 递归
     *
     * @param head
     * @return com.uin.leetcode_100.linkedlist.ListNode
     * @author wanglufei
     * @date 2022/9/7 2:46 PM
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    /**
     * 迭代
     *
     * @param head
     * @return com.uin.leetcode_100.linkedlist.ListNode
     * @author wanglufei
     * @date 2022/9/7 2:46 PM
     */
    public ListNode helper(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
