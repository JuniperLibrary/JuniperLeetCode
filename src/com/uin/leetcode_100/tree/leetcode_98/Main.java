package com.uin.leetcode_100.tree.leetcode_98;

import com.uin.leetcode_100.tree.TreeNode;

/**
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author wanglufei
 */
public class Main {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, Long.MIN_VALUE, root.val) && helper(root.right, root.val,
                Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
