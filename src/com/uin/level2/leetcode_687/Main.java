package com.uin.level2.leetcode_687;

import com.uin.leetcode_100.tree.TreeNode;

/**
 * 687. 最长同值路径
 * 给定一个二叉树的root，返回最长的路径的长度 ，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 遍历所有节点，以每个节点为中心点求最长路径（左右子树的边长之和），更新全局max。唯一的区别是，求出了左孩子的边长leftSize后，如果左孩子和当前节点不同值的话，那要把leftSize重新赋值成0。
 */
public class Main {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = root.left == null ? 0 : dfs(root.left) + 1;//把root加上
        int right = root.right == null ? 0 : dfs(root.right) + 1;
        //判断节点值是否相同
        if (left > 0 && root.left.val != root.val) {
            left = 0;
        }
        if (right > 0 && root.right.val != root.val) {
            right = 0;
        }

        max = Math.max(max, left + right);

        return Math.max(left, right);
    }
}
