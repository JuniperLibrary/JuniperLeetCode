package com.uin.day;

/**
 * @author dingchuan
 */
public class LeetCode82 {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0, head);
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
      //           1          1          2
      // cur  cur.next  cur.next.next
      if (cur.next.val == cur.next.next.val) {
        int x = cur.next.val;
        while (cur.next != null && cur.next.val == x) {
          cur.next = cur.next.next;
        }
      }else {
        cur = cur.next;
      }
    }
    return dummy.next;
  }

  public ListNode deleteDuplicates2(ListNode head){
    if (head == null || head.next == null){
      return head;
    }
    if (head.val != head.next.val){
      head.next = deleteDuplicates2(head.next);
      return head;
    }else {
      ListNode notDup = head.next.next;
      while (notDup!=null && notDup.val == head.val){
        notDup = notDup.next;
      }
      return deleteDuplicates2(notDup);
    }
  }
}
