package com.uin.feibu.leetcode_1746;

/**
 * LeetCode 1746. 经过一次操作后的最大子数组和
 * 你有一个整数数组 nums。你只能将一个元素 nums[i] 替换为 nums[i] * nums[i]。
 * 返回替换后的最大子数组和。
 * 示例 1：
 * 输入：nums = [2,-1,-4,-3]
 * 输出：17
 * 解释：你可以把-4替换为16(-4*(-4))，使nums = [2,-1,16,-3]. 现在，最大子数组和为 2 + -1 + 16 = 17.
 */
public class Main {
    public int maxSumAfterOperation(int[] nums) {
        int dp1 = 0;
        int dp2 = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            dp1 = Math.max(dp1 + nums[i], dp2 + nums[i] * nums[i]);
            dp2 = Math.max(nums[i] + dp2, 0);
            max = Math.max(dp1, max);
        }
        return max;
    }
}
