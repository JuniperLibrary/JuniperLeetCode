package com.day;

/**
 * 24.两两交换链表中的节点
 *
 * @author dingchuan
 */
public class LeetCode24 {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode node = swapPairs(head.next.next);
    ListNode p = head.next;
    p.next = head;
    head.next = node;
    return p;
  }

  public ListNode iterateSwapPairs(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode pre = dummy;
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      ListNode t =cur.next;
      cur.next=t.next;
      t.next=cur;
      pre.next=t;
      pre=cur;
      cur=cur.next;
    }
    return dummy.next;
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
