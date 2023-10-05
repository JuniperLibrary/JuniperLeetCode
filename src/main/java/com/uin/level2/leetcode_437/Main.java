package com.uin.level2.leetcode_437;

import com.uin.leetcode_100.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 我们首先想到的解法是穷举所有的可能，我们访问每一个节点 node，检测以 node 为起始节点且向下延深的路径有多少种。我们递归遍历每一个节点的所有可能的路径，然后将这些路径数目加起来即为返回结果。
 */
public class Main {
    /**
     * dfs
     *
     * @param root
     * @param targetSum
     * @return int
     * @author wanglufei
     * @date 2022/9/1 10:09 AM
     */
    //no ac
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 答案 = 当前节点的路径数 + 左子树的路径数 + 右子树的路径数
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        int ret = 0;
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        //当前节点的路径数 = 当前节点的值 + 左子树的路径数 + 右子树的路径数
        return ret + (dfs(root.left, targetSum - root.val)) + (dfs(root.right, targetSum - root.val));
    }

    /**
     * 前缀和
     *
     * @param root
     * @param targetSum
     * @return int
     * @author wanglufei
     * @date 2022/9/1 9:54 AM
     */
    public int helper(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return recursionPathSum(root, map, targetSum, 0L);
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     *
     * @param root      树节点
     * @param map       前缀和Map
     * @param targetSum 目标值
     * @param currSum   当前路径和
     * @return 满足题意的解
     */
    private int recursionPathSum(TreeNode root, Map<Long, Integer> map, int targetSum, Long currSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        //当前路径的和
        currSum += root.val;

        res += map.getOrDefault(currSum - targetSum, 0);
        map.put(currSum, map.getOrDefault(currSum - targetSum, 0) + 1);

        res += recursionPathSum(root.left, map, targetSum, currSum);
        res += recursionPathSum(root.right, map, targetSum, currSum);

        map.put(currSum, map.get(currSum) - 1);
        return res;
    }


}
