package com.uin.leetcode_100.dp.leetcode_416;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 */
public class Main {
    //回溯 超时
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum /= 2;
        return helper(nums, 0, sum);
    }

    private boolean helper(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index == nums.length || index < 0) return false;
        if (helper(nums, index + 1, target - nums[index])) return true;
        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]) {
            j++;
        }
        return helper(nums, j, target);
    }

    public boolean dpSolution(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= 0; j--) {
                if (j >= num) {
                    dp[j] = dp[j] || dp[j - num];
                }
            }
        }
        return dp[sum];
    }
}
