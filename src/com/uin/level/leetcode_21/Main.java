package com.uin.level.leetcode_21;
/**
 * 21 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Main {
    /**
     * 递归
     *
     * @param list1
     * @param list2
     * @return com.uin.level.leetcode_21.ListNode
     * @author wanglufei
     * @date 2022/8/14 11:16 AM
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * 迭代
     *
     * @param list1
     * @param list2
     * @return com.uin.level.leetcode_21.ListNode
     * @author wanglufei
     * @date 2022/8/14 11:17 AM
     */
    public ListNode helpers(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (list1 == null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;

        return preHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
