package main.java.com.uin.leetcode_100.tree.leetcode_669;

import main.java.com.uin.leetcode_100.tree.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 */
public class Main {
    /**
     * 递归
     *
     * @param root
     * @param low
     * @param high
     * @return com.uin.leetcode_100.tree.TreeNode
     * @author wanglufei
     * @date 2022/9/10 9:44 AM
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.left = trimBST(root.right, low, high);
            return root;
        }
    }

    /**
     * 迭代
     *
     * @param root
     * @param low
     * @param high
     * @return com.uin.leetcode_100.tree.TreeNode
     * @author wanglufei
     * @date 2022/9/10 9:45 AM
     */
    public TreeNode helper(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        if (root == null) {
            return null;
        }
        for (TreeNode node = root; node.left != null; ) {
            if (node.left.val < low) {
                node.left = node.left.right;
            } else {
                node = node.left;
            }
        }
        for (TreeNode node = root; node.right != null; ) {
            if (node.right.val > high) {
                node.right = node.right.left;
            } else {
                node = node.right;
            }
        }
        return root;
    }
}
