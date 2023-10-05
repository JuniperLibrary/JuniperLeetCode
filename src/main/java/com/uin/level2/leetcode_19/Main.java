package main.java.com.uin.level2.leetcode_19;

import main.java.com.uin.leetcode_100.linkedlist.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class Main {
    int count=0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //递归出口
        if (head==null){
            return null;
        }
        head.next=removeNthFromEnd(head.next,n);
        count++;
        if (count==n){
            return head.next;
        }
        return head;
    }
}
