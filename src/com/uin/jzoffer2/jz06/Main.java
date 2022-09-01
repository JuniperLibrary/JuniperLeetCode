package com.uin.jzoffer2.jz06;

import com.uin.leetcode_100.linkedlist.ListNode;

import java.util.ArrayList;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class Main {
    ArrayList<Integer> temp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[temp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        temp.add(head.val);
    }
}
