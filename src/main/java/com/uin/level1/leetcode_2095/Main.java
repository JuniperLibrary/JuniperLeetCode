package com.uin.level1.leetcode_2095;

import com.uin.leetcode_100.linkedlist.ListNode;

/**
 * 2095. 删除链表的中间节点
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * ————————————————————————————————————————————————————————————————————————
 * 输入：head = [1,3,4,7,1,2,6]
 * 输出：[1,3,4,1,2,6]
 * 解释：
 * 上图表示给出的链表。节点的下标分别标注在每个节点的下方。
 * 由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
 * 返回结果为移除节点后的新链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
