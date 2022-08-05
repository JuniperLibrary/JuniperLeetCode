package com.uin.leetcode_100.linkedlist.leetcode_146;

import java.util.HashMap;

/**
 * @author wanglufei
 */
class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    /**
     * 头部的元素 最老的元素
     */
    private Node head;
    /**
     * 尾部的元素 最新的元素
     */
    private Node tail;

    /**
     * @param capacity
     * @return null
     * @author wanglufei
     * @date 2022/8/4 3:35 PM
     */
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    /**
     * @param key
     * @return int
     * @author wanglufei
     * @date 2022/8/4 3:35 PM
     */
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        //判断当前node是不是最新的
        if (node != tail) {
            //如果node是head，需要把它移动的末尾
            if (node == head) {
                head = head.next;
            } else {
                // node 不是head
                //要把它取出来，然后把它前边和后边的连接到一起
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            //把这个点方法最后
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        //已经存在就更新值
        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }
}
