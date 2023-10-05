package main.java.com.uin.leetcode_100.tree.leetcode_235;


import main.java.com.uin.leetcode_100.tree.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class Main {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == q.val) return p;
        if (p.val == root.val || q.val == root.val) return root;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }
}
