package com.uin.leetcode_100.tree.leetcode_543;

import com.uin.leetcode_100.tree.TreeNode;

public class Main {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        dfs(root, diameter);
        return diameter[0];
    }

    private int dfs(TreeNode root, int[] diameter) {
        if (root == null) return 0;
        int lh = dfs(root.left, diameter);
        int rh = dfs(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return Math.max(lh, rh) + 1;
    }
}
