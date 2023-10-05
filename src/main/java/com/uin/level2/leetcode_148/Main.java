package main.java.com.uin.level2.leetcode_148;

import main.java.com.uin.leetcode_100.linkedlist.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 对链表自顶向下归并排序的过程如下。
 * <p>
 * - 找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动 2 步，
 * 慢指针每次移动 1 步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
 * <p>
 * - 对两个子链表分别排序。
 * <p>
 * - 将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「21. 合并两个有序链表」的做法，将两个有序的子链表进行合并。
 */
public class Main {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;

        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);

        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy, temp1 = head1, tmp2 = head2;
        while (temp1 != null && tmp2 != null) {
            if (temp1.val <= tmp2.val) {
                tmp.next = temp1;
                temp1 = temp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }

        if (temp1 != null) {
            tmp.next = temp1;
        } else if (tmp2 != null) {
            tmp.next = tmp2;
        }
        return dummy.next;
    }


    public ListNode helper(ListNode head) {
        //终止条件，没有节点或者一个节点就不需要排序了
        if (head == null || head.next == null) return head;
        //快慢指针找到链表中点
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //从中间断开
        ListNode rHead = slow.next;
        slow.next = null;
        //递归处理前后两个链表
        ListNode left = sortList(head);
        ListNode right = sortList(rHead);
        //连个链表处理完，进行合并
        return merge_helper(left, right);
    }

    public ListNode merge_helper(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        //res为哑节点，方便处理链表。 resTail为res的尾指针，用来插入节点
        ListNode res = new ListNode(), resTail = res;
        //left和right哪个小就接入res
        while (left != null && right != null) {
            if (left.val < right.val) {
                resTail.next = left;
                left = left.next;
            } else {
                resTail.next = right;
                right = right.next;
            }
            resTail = resTail.next;
        }
        //最后如果两个链表还有剩余
        if (left != null) resTail.next = left;
        if (right != null) resTail.next = right;
        //返回结果
        return res.next;
    }
}
