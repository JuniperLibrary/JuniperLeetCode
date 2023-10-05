package main.java.com.uin.leetcode_100.tree.leetcode_98;

import main.java.com.uin.leetcode_100.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
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

    /**
     * 中序遍历
     *
     * @param root
     * @return boolean
     * @author wanglufei
     * @date 2022/8/19 3:23 PM
     */
    List<Integer> list = new ArrayList<>();
    public boolean isBSTValid(TreeNode root) {
        if (root == null) return true;
        traversal(root);//inorder
        int preMin = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (preMin < list.get(i)) {
                preMin = list.get(i);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * inorder traversal
     *
     * @param root
     * @author wanglufei
     * @date 2022/8/19 3:41 PM
     */
    private void traversal(TreeNode root) {
        //递归出口
        if (root == null) return;

        //left、root、right
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }


}
