package main.java.com.uin.level2.leetcode_234;

import main.java.com.uin.leetcode_100.linkedlist.ListNode;

import java.util.ArrayList;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 */
public class Main {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        //将链表的值复制到数组中
        ListNode cur = head;
        while (cur!=null) {
            list.add(cur.val);
            cur=cur.next;
        }

        //使用二分
        int left =0;
        int right =list.size()-1;
        while (left<right){
            if (!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
