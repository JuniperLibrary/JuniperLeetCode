package com.uin.level2.leetcode_110;

import com.uin.leetcode_100.tree.TreeNode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Main {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        if (lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }
}
