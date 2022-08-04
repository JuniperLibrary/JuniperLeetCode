package com.uin.leetcode_100.array.LeetCode_39;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode 39 组合总和 回溯法
 *
 * @author wanglufei
 * @date 2022/7/13 3:20 PM
 */
public class Main {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> solution = solution(candidates, target);
        for (List<Integer> integers : solution) {
            System.out.println(integers);
        }
    }

    /**
     * 找出 candidates 中可以使数字 和 为目标数 target 的 所有 不同组合 ，并以列表形式返回。
     * 你可以按 任意顺序 返回这些组合。
     *
     * @param candidates
     * @param target
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author wanglufei
     * @date 2022/7/13 3:31 PM
     */
    public static List<List<Integer>> solution(int[] candidates, int target) {
        ArrayList<List<Integer>> bank = new ArrayList<>();
        int length = candidates.length;
        if (length == 0) return bank;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, length, target, path, bank);
        return bank;
    }

    /**
     * dfs深度优先算法
     *
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     目标值
     * @param path       从根节点到叶子节点的路径，是一个栈
     * @param res        结果集列表
     * @author wanglufei
     * @date 2022/7/15 10:44 AM
     */
    public static void dfs(int candidates[], int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        //如果叶子节点，是负数，直接return
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            //{2,3,6,7}
            path.add(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);
            //状态重置
            path.removeLast();
        }
    }

}
