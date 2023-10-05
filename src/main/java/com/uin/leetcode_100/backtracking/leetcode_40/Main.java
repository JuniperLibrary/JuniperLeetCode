package main.java.com.uin.leetcode_100.backtracking.leetcode_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class Main {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, target);
        return res;
    }

    private void helper(int[] candidates, int start, int target) {
        //递归出口
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //剪纸
            if (candidates[i] > target) break;
            //去重
            if (i > start && candidates[i - 1] == candidates[i]) continue;
            list.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
