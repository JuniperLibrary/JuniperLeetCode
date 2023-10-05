package com.uin.jzoffer2.jz53;

import com.uin.leetcode_100.tree.TreeNode;

import java.util.Stack;
//剑指 Offer II 053. 二叉搜索树中的中序后继
public class Main {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return dfs(root, p);
    }

    TreeNode prev = null;

    private TreeNode dfs(TreeNode root, TreeNode p) {
        if (root == null) return null;

        TreeNode left = dfs(root.left, p);

        if (prev == p) {
            prev = root;
            return root;
        }

        prev = root;
        TreeNode right = dfs(root.right, p);
        if (left != null) return left;
        if (right != null) {
            return right;
        }
        return null;
    }

    private TreeNode helper(TreeNode root, TreeNode p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev == p) {
                return root;
            }
            prev=root;
            root=root.right;
        }
        return null;
    }
}
