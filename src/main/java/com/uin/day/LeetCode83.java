package com.uin.day;

/**
 * LeetCode 83 删除排序链表中的重复元素
 *
 * @author dingchuan
 */
public class LeetCode83 {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    if (head.val == head.next.val) {
      head = deleteDuplicates(head.next);
    } else {
      head.next = deleteDuplicates(head.next);
    }
    return head;
  }

  public ListNode deleteDuplicates2(ListNode head) {
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }
}
