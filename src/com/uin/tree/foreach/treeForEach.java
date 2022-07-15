package com.uin.tree.foreach;

import java.util.*;

/**
 * 二叉树的中序遍历--迭代法
 */
public class treeForEach {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(1, null);
        list.add(2, 2);
        list.add(3, 3);
        TreeNode treeNode = new TreeNode();

        List<Integer> solution = solution(treeNode);


    }

    public static List<Integer> solution(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        //判断边界条件
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        //1. 现将根节点放进去
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.removeLast();
            res.add(treeNode.val);
            //先放右子节点
            if (treeNode.right != null) {
                stack.add(treeNode.right);
            }
            //再放左子节点
            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }
        }
        return res;
    }
}

