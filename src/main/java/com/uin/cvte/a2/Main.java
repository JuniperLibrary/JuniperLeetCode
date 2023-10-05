package com.uin.cvte.a2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * <p>
 * 输入：[3,6,7,9] ,target=9
 * 输出：[[3,3,3],[3,6],[9]]
 * Leetcode 39（同一个 数字可以 无限制重复被选取），类似于LeetCode 40(这个题目每个元素只可以使用一次)
 */
public class Main {
    public List<List<Integer>> solutions(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) return res;
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(candidates, 0, len, target, stack, res);

        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> stack, List<List<Integer>> res) {
        //如果叶子节点，是负数，直接return
        if (target < 0) return;

        if (target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        //重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            //{2,3,6,7}
            stack.add(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], stack, res);
            //状态重置
            stack.removeLast();
        }
    }
}
