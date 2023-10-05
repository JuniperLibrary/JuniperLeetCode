package com.uin.tree.leetcode_589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N 叉树的前序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔
 */
public class Main {
    ArrayList<Integer> res = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author wanglufei
     * @date 2022/8/17 2:41 PM
     */
    public List<Integer> preorder(Node root) {
        if (root == null) return res;

        res.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return res;
    }

    /**
     * 遍历
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author wanglufei
     * @date 2022/8/17 2:41 PM
     */
    public List<Integer> solution(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size()-1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
