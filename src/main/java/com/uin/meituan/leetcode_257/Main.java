package main.java.com.uin.meituan.leetcode_257;

import main.java.com.uin.leetcode_100.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 */
public class Main {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    /**
     * 深度优先搜索
     *
     * @param root
     * @param path
     * @param paths
     * @author wanglufei
     * @date 2022/9/2 9:27 AM
     */
    private void dfs(TreeNode root, String path, ArrayList<String> paths) {
        if (root != null) {
            StringBuffer sb = new StringBuffer(path);
            sb.append(Integer.valueOf(root.val));
            if (root.left == null && root.right == null) {
                paths.add(sb.toString());
            } else {
                sb.append("->");
                dfs(root.left, sb.toString(), paths);
                dfs(root.right, sb.toString(), paths);
            }
        }
    }

    /**
     * 广度优先搜索
     *
     * @param root
     * @author wanglufei
     * @date 2022/9/2 9:28 AM
     */
    public List<String> bfs(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuilder(path).append("->").append(node.left.val).toString());
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuilder(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }


}
