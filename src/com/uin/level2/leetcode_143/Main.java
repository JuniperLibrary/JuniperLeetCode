package com.uin.level2.leetcode_143;

import com.uin.leetcode_100.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 */
public class Main {
    /**
     * 线性表
     *
     * @param head
     * @author wanglufei
     * @date 2022/9/3 7:53 AM
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /**
     * @param head
     * @author wanglufei
     * @date 2022/9/3 8:10 AM
     */

    public void solution(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;

        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    /**
     * 合并
     *
     * @param l1
     * @param l2
     * @author wanglufei
     * @date 2022/9/3 7:58 AM
     */
    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_;
        ListNode l2_;
        while (l1 != null && l2 != null) {
            l1_ = l1.next;
            l2_ = l2.next;

            l1.next = l2;
            l1 = l1_;
            l2.next = l1;
            l2 = l2_;
        }
    }

    /**
     * 反转
     *
     * @param head
     * @return com.uin.leetcode_100.linkedlist.ListNode
     * @author wanglufei
     * @date 2022/9/3 7:57 AM
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }

    /**
     * 找到链表的中点节点
     *
     * @param head
     * @return com.uin.leetcode_100.linkedlist.ListNode
     * @author wanglufei
     * @date 2022/9/3 7:55 AM
     */
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
