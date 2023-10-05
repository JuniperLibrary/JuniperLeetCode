package main.java.com.uin.level2.leetcode_108;

import main.java.com.uin.leetcode_100.tree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class Main {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * 中序遍历，总是选择中间位置左边的数字作为根节点
     *
     * @param nums
     * @param left
     * @param right
     * @return com.uin.leetcode_100.tree.TreeNode
     * @author wanglufei
     * @date 2022/9/3 2:41 PM
     */
    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {

        if (right < left) {
            return null;
        }

        if (right == left) {
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
