package com.uin.level.leetcode_138;

import java.util.HashMap;

/**
 * 138. 复制带随机指针的链表
 */
public class Main {
    /**
     * 遍历
     *
     * @param head
     * @return com.uin.level.leetcode_138.Node
     * @author wanglufei
     * @date 2022/8/15 8:53 PM
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        for (Node curr = head; curr != null; curr = curr.next) {
            map.put(curr, new Node(curr.val));
        }

        for (Node curr = head; curr != null; curr = curr.next) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
        }
        return map.get(head);
    }

    /**
     * 递归
     *
     * @param head
     * @return com.uin.level.leetcode_138.Node
     * @author wanglufei
     * @date 2022/8/15 8:53 PM
     */
    HashMap<Node, Node> map = new HashMap<>();

    public Node recur(Node head) {
        if (head == null) return null;
        Node newNode = new Node(head.val);
        map.put(head, newNode);

        newNode.next = recur(head.next);
        newNode.random = map.get(head.random);
        return newNode;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
