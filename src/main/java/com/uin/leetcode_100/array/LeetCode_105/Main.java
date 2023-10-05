package main.java.com.uin.leetcode_100.array.LeetCode_105;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanglufei
 */
public class Main {
    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(pre, in);
        System.out.println(treeNode);
    }

    /**
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return com.uin.LeetCode_100.array.LeetCode_105.TreeNode
     * @author wanglufei
     * @date 2022/7/31 10:30 AM
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(preorder, inorder, 0, 0, inorder.length - 1, map);
    }

    /**
     * @param preorder
     * @param inorder
     * @param preStart 前序遍历的开始索引
     * @param inStart  中序遍历的开始索引
     * @param inEnd    中序遍历
     * @param map
     * @return com.uin.LeetCode_100.array.LeetCode_105.TreeNode
     * @author wanglufei
     * @date 2022/7/31 10:32 AM
     */
    private static TreeNode help(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd,
                                 Map<Integer, Integer> map) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        Integer rootIndex = map.get(preorder[preStart]);
        root.left = help(preorder, inorder, preStart + 1, inStart, rootIndex - 1, map);
        root.right = help(preorder, inorder, preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd, map);
        return root;
    }
}
