package com.uin.level2.leetcode_230;

import com.uin.leetcode_100.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class Main {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}

/**
 * import java.util.*;
 *
 * class AuthenticationManager {
 *
 *     public int kthSmallest(TreeNode root, int k) {
 *         Deque<TreeNode> stack = new ArrayDeque<>();
 *
 *         while (root != null || !stack.isEmpty()) {
 *             while (root != null) {
 *                 stack.push(root);
 *                 root = root.left;
 *             }
 *             root = stack.pop();
 *             --k;
 *             if (k == 0) {
 *                 break;
 *             }
 *             root = root.right;
 *         }
 *         return root.val;
 *     }
 *
 *     public static void Main(String[] args) {
 *         Scanner scanner = new Scanner(System.in);
 *         String inputStr = scanner.nextLine();
 *         String pStr = scanner.nextLine();
 *         String arrayStr = inputStr.substring(1, inputStr.lastIndexOf("]"));
 *         String[] arrayStrArray = arrayStr.split(",");
 *         Integer[] array = new Integer[arrayStrArray.length];
 *         for (int i = 0; i < arrayStrArray.length; i++) {
 *             if ("null".equals(arrayStrArray[i])) {
 *                 continue;
 *             }
 *             array[i] = Integer.valueOf(arrayStrArray[i]);
 *         }
 *
 *         TreeNode root = createTree(0, array);
 *         System.out.println(new AuthenticationManager().kthSmallest(root, Integer.parseInt(pStr)));
 *     }
 *
 *     static TreeNode createTree(int rootIndex, Integer[] values) {
 *         if (rootIndex >= values.length) {
 *             return null;
 *         }
 *         if (values[rootIndex] == null) {
 *             return null;
 *         }
 *         TreeNode rootNode = new TreeNode();
 *         rootNode.val = values[rootIndex];
 *         rootNode.left = createTree(2 * rootIndex + 1, values);
 *         rootNode.right = createTree(2 * rootIndex + 2, values);
 *         return rootNode;
 *     }
 *
 *     static class TreeNode {
 *         TreeNode left;
 *         TreeNode right;
 *         int val;
 *     }
 * }
 */
