package main.java.com.uin.leetcode_100.tree.jz07;

import main.java.com.uin.leetcode_100.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Main {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        //前序遍历的第一个元素是根元素
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        //中序的索引
        int inorder_index = 0;
        for (int i = 1; i < preorder.length; i++) {
            //左
            int preorder_val = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorder_index]) {
                node.left = new TreeNode(preorder_val);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorder_index]) {
                    node = stack.pop();
                    //中序遍历指针向前移动
                    inorder_index++;
                }
                node.right = new TreeNode(preorder_val);
                stack.push(node.right);
            }
        }
        return root;
    }
}
