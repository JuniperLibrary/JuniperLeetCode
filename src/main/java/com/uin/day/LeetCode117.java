package com.uin.day;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {

  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};

public class LeetCode117 {


  public Node connect(Node root) {
    // 117 填充每个节点的下一个右侧节点的指针
    // 填充它的每个next指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点。
    // 则将next指针设置为null
    // 初始状态下，所有next指针都被设置为null

    if (null == root) {
      return root;
    }
    Deque<Node> q = new ArrayDeque<>();
    q.offer(root);
    while (!q.isEmpty()) {
      Node p = null;
      for (int i = q.size(); i > 0; i--) {
        Node node = q.poll();
        if (p != null) {
          p.next = node;
        }
        p = node;
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
    }
    return root;
  }
}
