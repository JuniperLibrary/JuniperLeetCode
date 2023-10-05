package main.java.com.uin.leetcode_100.dfs.leetcode_652;

import main.java.com.uin.leetcode_100.tree.TreeNode;

import java.util.*;


/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树 root，返回所有重复的子树。
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 */
public class Main {
    Map<String, TreeNode> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<TreeNode>(set);
    }

    private String dfs(TreeNode node) {
        if (node == null) {
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")(");
        sb.append(dfs(node.right));
        String serial = sb.toString();
        if (map.containsKey(serial)) {
            set.add(map.get(serial));
        } else {
            map.put(serial, node);
        }
        return serial;
    }
}
