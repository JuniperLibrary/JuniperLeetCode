package com.uin.leetcode_100.dp.leetcode_746;

/**
 * 746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class Main {
    public int minCostClimbingStairs(int[] cost) {
        int twoStep = cost[0];
        int oneStep = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int current = Math.min(twoStep, oneStep) + cost[i];
            twoStep = oneStep;
            oneStep = current;
        }
        return Math.min(oneStep, twoStep);
    }

    public int minCost(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
