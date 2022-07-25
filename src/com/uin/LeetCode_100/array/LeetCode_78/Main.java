package com.uin.LeetCode_100.array.LeetCode_78;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author wanglufei
 * @date 2022/7/25 10:48 PM
 */
public class Main {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //求子集 自然就想到了回溯
        helper(result, nums, 0, new ArrayList<>());
        return result;
    }

    public void helper(List<List<Integer>> result, int[] nums, int index, List<Integer> children) {
        result.add(new ArrayList<Integer>(children));
        for (int i = index; i < nums.length; i++) {
            children.add(nums[i]);
            helper(result, nums, i + 1, children);
            children.remove(children.size() - 1);
        }
    }
}
