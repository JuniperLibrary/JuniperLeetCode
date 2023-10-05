package main.java.com.uin.day;

/**
 * 21.合并两个有序的链表
 *
 * @author dingchuan
 */
public class LeetCode21 {

  /*输入：l1 = [1,2,4], l2 = [1,3,4]
  输出：[1,1,2,3,4,4]*/
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }

    if (list1.val <= list2.val) {
      list1.next = mergeTwoLists(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists(list1, list2.next);
      return list2;
    }


  }
}
