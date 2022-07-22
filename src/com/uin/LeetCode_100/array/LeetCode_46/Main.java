package com.uin.LeetCode_100.array.LeetCode_46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 46 全排列
 *
 * @author wanglufei
 * @date 2022/7/18 9:32 AM
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> solution = solution(nums);
        for (List<Integer> list : solution) {
            System.out.println(list);
        }
    }

    /**
     * 按顺序枚举每一个位置可能出现的数字
     * <p>
     * 之前已经出现的数字在接下来要选择的数字不能出现
     * 算法思路：
     * 全排列问题的树形结构 回溯法
     *
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author wanglufei
     * @date 2022/7/18 9:36 AM
     */
    public static List<List<Integer>> solution(int nums[]) {
        List<List<Integer>> bank = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, bank, 0);
        return bank;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        //所有数都填完了 递归的出口
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            //动态的维护数组 交换指定列表中指定位置的元素
            Collections.swap(output, first, i);
            //继续递归填下一个数
            backtrack(n, output, res, first+1);
            //撤销操作
            Collections.swap(output, first, i);
        }
    }
}
