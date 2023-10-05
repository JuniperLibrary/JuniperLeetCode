package main.java.com.uin.tencent.tree;

import main.java.com.uin.leetcode_100.tree.TreeNode;

import java.util.*;

/**
 * 删层子树
 * 牛牛有一棵n个节点的二叉树，该二叉树每个节点的权值为1。牛牛想要删掉该树其中的k层节点，删除序列为。
 */
public class Main {
    public ArrayList<TreeNode> deleteLevel(TreeNode root, ArrayList<Integer> a) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) {
            set.add(num);
        }
        set.add(0);
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                if (set.contains(depth - 1) && !set.contains(depth))
                    list.add(node);
                if (!set.contains(depth) && set.contains(depth + 1)) {
                    node.left = null;
                    node.right = null;
                }
            }
        }
        return list;
    }
}
