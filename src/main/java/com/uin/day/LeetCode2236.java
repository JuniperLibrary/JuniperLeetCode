package com.uin.day;

/*
2236. 判断根结点是否等于子结点之和

给你一个 二叉树 的根结点 root，该二叉树由恰好 3 个结点组成：根结点、左子结点和右子结点。

如果根结点值等于两个子结点值之和，返回 true ，否则返回 false 。
*/

public class LeetCode2236 {

  public boolean checkTree(TreeNode root) {
    return root.val == root.left.val + root.right.val;
  }
  /*
  现在把题目扩展一下：假设输入的是一棵完全二叉树（每个节点都有 000 或 222 个儿子），树上有 nnn 个节点（n≥3n\ge 3n≥3）。
  要求判断除了叶子节点，是否每个节点的值都等于其左右儿子的节点值之和。
   */
  /*
  如果当前节点是叶子节点，直接返回 true，表示无需判断叶子。
  否则，如果当前节点的节点值不等于其儿子的节点值之和，返回 false。
  否则，递归左右儿子，如果它们都返回 true，那么当前节点返回 true，否则返回 false。
   */

  public boolean checkTreeN(TreeNode root){
    // 递归边界 判断 root 是否为子节点
    if (root.left == root.right){
      return true;
    }
    return root.val == root.left.val + root.right.val && checkTreeN(root.left) && checkTree(root.right);
  }
}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
