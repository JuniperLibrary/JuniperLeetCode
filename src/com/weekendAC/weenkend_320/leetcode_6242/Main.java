package com.weekendAC.weenkend_320.leetcode_6242;

import com.uin.leetcode_100.tree.TreeNode;

import java.util.*;

/**
 * 6242. 二叉搜索树最近节点查询
 * 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
 * <p>
 * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
 * <p>
 * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
 * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
 * 返回数组 answer 。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * <p>
 * <p>
 * 输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
 * 输出：[[2,2],[4,6],[15,-1]]
 * 解释：按下面的描述找出并返回查询的答案：
 * - 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
 * - 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
 * - 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
 * 示例 2 ：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,null,9], queries = [3]
 * 输出：[[-1,4]]
 * 解释：树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [2, 105] 内
 * 1 <= Node.val <= 106
 * n == queries.length
 * 1 <= n <= 105
 * 1 <= queries[i] <= 106
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> queries = new ArrayList<>();
        queries.add(2);
        queries.add(5);
        queries.add(16);
        int max_queries = queries.stream().max(Integer::max).get();
        System.out.println(max_queries);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
//        int max_queries = queries.stream().max(Integer::max).get();
//        int min_queries = queries.stream().max(Integer::min).get();
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> level = new ArrayList<>();
//
//        List<Integer> nodeList = new ArrayList<Integer>();
//        // 遍历二叉搜索树
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            nodeList.add(Integer.valueOf(node.val));
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//        }
//
//        for (Integer re : nodeList) {
//            for (Integer query : queries) {
//                if (re <= query && re >= query) {
//                    level.add(re);
//                    level.add(re);
//                    ans.add(level);
//                } else if (re <= query) {
//                    level.add(re);
//                    level.add(-1);
//                    ans.add(level);
//                }
//            }
//        }
//        return ans;
    }

    public List<List<Integer>> helper(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        process(root, treeSet);
        List<List<Integer>> ans = new ArrayList<>();

        for (int q : queries) {
            // 小于、等于
            Integer min = treeSet.floor(q);
            if (min == null) {
                min = -1;
            }
            Integer max = treeSet.ceiling(q);
            if (max == null) {
                max = -1;
            }
            List<Integer> list = new ArrayList<>();
            list.add(min);
            list.add(max);
            ans.add(list);
        }
        return ans;
    }

    private void process(TreeNode root, TreeSet<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        process(root.left, set);
        process(root.right, set);
    }
}
