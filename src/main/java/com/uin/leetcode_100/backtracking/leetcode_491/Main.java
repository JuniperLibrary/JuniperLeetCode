package main.java.com.uin.leetcode_100.backtracking.leetcode_491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 491. 递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 */
public class Main {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, 0, nums, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int start, int[] nums, ArrayList<Integer> temp) {
        if (temp.size() >= 2) {
            res.add(new ArrayList<>(temp));
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            int curr = nums[i];

            if (visited.contains(curr)) {
                continue;
            }

            if (temp.size() == 0 || curr >= temp.get(temp.size() - 1)) {
                visited.add(curr);
                temp.add(curr);
                dfs(res, i + 1, nums, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
