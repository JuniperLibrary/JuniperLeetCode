package main.java.com.uin.weenkend86.leetcode_1746;

/**
 * LeetCode 1746 经过一次操作后的最大子数组和
 */
public class Main {
    public int maxSumAfterOperation(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];

        int maxSum = dp[0][1];

        for (int i = 0; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
            dp[i][1] = Math.max(nums[i] * nums[i], Math.max(dp[i - 1][0] + nums[i] * nums[i], dp[i - 1][1] + nums[i]));
            maxSum = Math.max(maxSum, dp[i][1]);
        }
        return maxSum;
    }
}
