package com.uin.tuhu23.a1;

import java.util.*;

/**
 * 【2023届途虎校招】Java开发工程师笔试01卷---途虎十周年庆典烟花的颜色种类
 * 一颗二叉树root代表烟花，节点值表示巨型烟花这一位置的颜色值，请你帮忙小乐帮忙计算巨型烟花一共有多少种
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 烟花颜色数
     *
     * @param root TreeNode类 烟花二叉树
     * @return int整型
     */
    public int numColor(TreeNode root) {
        // write code here
        HashSet<Integer> set = new HashSet<>();

        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            set.add(Integer.valueOf(node.val));
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return set.size();
    }
}
