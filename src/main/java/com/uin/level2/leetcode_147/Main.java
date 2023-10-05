package main.java.com.uin.level2.leetcode_147;

import main.java.com.uin.leetcode_100.linkedlist.ListNode;

/**
 * 147. 对链表进行插入排序
 * <p>
 * 给定单个链表的头head，使用 插入排序 对链表进行排序，并返回排序后链表的头。
 * <p>
 * 插入排序算法的步骤:
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 * <p>
 * 对链表进行插入排序。
 */

/**
 * 对链表进行插入排序的具体过程如下。
 * <p>
 * 首先判断给定的链表是否为空，若为空，则不需要进行排序，直接返回。
 * <p>
 * 创建哑节点 dummyHead，令 dummyHead.next = head。引入哑节点是为了便于在 head 节点之前插入节点。
 * <p>
 * 维护 lastSorted 为链表的已排序部分的最后一个节点，初始时 lastSorted = head。
 * <p>
 * 维护 curr 为待插入的元素，初始时 curr = head.next。
 * <p>
 * 比较 lastSorted 和 curr 的节点值。
 * <p>
 * 若 lastSorted.val <= curr.val，说明 curr 应该位于 lastSorted 之后，将 lastSorted 后移一位，curr 变成新的 lastSorted。
 * <p>
 * 否则，从链表的头节点开始往后遍历链表中的节点，寻找插入 curr 的位置。令 prev 为插入 curr 的位置的前一个节点，进行如下操作，完成对 curr 的插入：
 * <p>
 * <p>
 * lastSorted.next = curr.next
 * curr.next = prev.next
 * prev.next = curr
 * <p>
 * <p>
 * 令 curr = lastSorted.next，此时 curr 为下一个待插入的元素。
 * <p>
 * 重复第 5 步和第 6 步，直到 curr 变成空，排序结束。
 * <p>
 * 返回 dummyHead.next，为排序后的链表的头节点。
 */
public class Main {
    public ListNode insertionSortList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lastSorted = head;
        //初始化待排序的节点
        ListNode cur = head.next;

        while (cur != null) {
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
        }
        return dummy.next;
    }

    public ListNode helper(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode prev = dummy;
            ListNode next = cur.next;

            while (prev.next != null && prev.next.val <= cur.val) {
                prev = prev.next;
            }

            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
