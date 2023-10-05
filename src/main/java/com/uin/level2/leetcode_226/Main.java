package main.java.com.uin.level2.leetcode_226;

import main.java.com.uin.leetcode_100.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 */
public class Main {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTree(root.left);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        return root;
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node  = queue.poll();
            TreeNode rightTree = node.right;
            node.right=node.left;
            node.left=rightTree;

            if (node.left!=null){
                queue.offer(node.left);
            }

            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}
