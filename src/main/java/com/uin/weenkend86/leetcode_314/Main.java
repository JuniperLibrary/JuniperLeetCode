package main.java.com.uin.weenkend86.leetcode_314;

import main.java.com.uin.leetcode_100.tree.TreeNode;

import java.util.*;

/**
 * Leetcode 314 二叉树的垂直遍历
 * 给定一个二叉树，返回其结点 垂直方向（从上到下，逐列）遍历的值。
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 */
public class Main {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        // 层序遍历对应的即诶单队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 节点对应的位置队列
        Queue<Integer> posQueue = new LinkedList<>();
        posQueue.offer(0);

        Map<Integer, List<Integer>> map = new HashMap<>();
        // 最左侧的位置
        int minPos = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            int pos = posQueue.poll();
            List<Integer> list = map.getOrDefault(pos, new LinkedList<>());
            list.add(poll.val);
            map.put(pos, list);

            if (poll.left != null) {
                queue.offer(poll.left);
                posQueue.offer(pos - 1);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                posQueue.offer(pos + 1);
            }
            // 维护左侧位置
            minPos = Math.min(minPos, pos);
        }

        for (int i = minPos; i < minPos + map.size(); i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
}
