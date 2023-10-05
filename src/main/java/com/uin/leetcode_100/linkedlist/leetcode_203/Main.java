package main.java.com.uin.leetcode_100.linkedlist.leetcode_203;

import main.java.com.uin.leetcode_100.linkedlist.ListNode;

/**
 * 203.移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class Main {
    /**
     * 迭代
     *
     * @param head
     * @param val
     * @return com.uin.leetcode_100.linkedlist.ListNode
     * @author wanglufei
     * @date 2022/9/16 6:39 PM
     */
    public ListNode removeElements(ListNode head, int val) {
        //1.遍历链表找到val相等的值
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                //2.删除节点
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 递归
     *
     * @param head
     * @param val
     * @return com.uin.leetcode_100.linkedlist.ListNode
     * @author wanglufei
     * @date 2022/9/16 6:40 PM
     */
    public ListNode recurse(ListNode head, int val) {
        //1.递归出口
        if (head == null) {
            return head;
        }
        head.next = recurse(head.next, val);
        return head.val == val ? head.next : head;
    }
}
