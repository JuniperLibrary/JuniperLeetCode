package main.java.com.uin.leetcode_100.backtracking.leetcode_46;

import java.util.*;

/**
 * 46.全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Main {
    /**
     * 深度优先遍历
     *
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author wanglufei
     * @date 2022/9/15 11:54 PM
     */
    public List<List<Integer>> premute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        //递归终止条件
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            //到上一层 回溯 逆操作
            path.removeLast();
            used[i] = false;
        }
    }

    /**
     * 回溯
     *
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author wanglufei
     * @date 2022/9/15 11:54 PM
     */
    public static List<List<Integer>> backtrack(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        back(n, output, res, 0);
        return res;
    }

    private static void back(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            back(n, output, res, first + 1);
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(backtrack(new int[]{1, 2, 3}));
    }

}
