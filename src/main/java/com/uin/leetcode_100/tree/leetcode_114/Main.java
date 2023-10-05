package main.java.com.uin.leetcode_100.tree.leetcode_114;

import main.java.com.uin.leetcode_100.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wanglufei
 */
public class Main {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            curr.left=null;
        }
    }
}
