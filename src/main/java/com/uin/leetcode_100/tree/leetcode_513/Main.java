package main.java.com.uin.leetcode_100.tree.leetcode_513;

import main.java.com.uin.leetcode_100.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 */
public class Main {

    public static int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //返回队列的头部
            ans = queue.peek().val;
            int size = queue.size();

            //一直循环
            while (--size >= 0) {
                //将跟节点弹出来
                TreeNode poll = queue.poll();
                //将根节点的左子树遍历，方放到queue
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                //将根节点的右子树遍历，方放到queue
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return ans;
    }
}
