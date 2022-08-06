package com.uin.leetcode_100.dp.leetcode_62;

public class Main {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        //初始化第一列为1
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[i] = dp[i] + dp[i - 1];
            }
        }
        return dp[m - 1];
    }
}
