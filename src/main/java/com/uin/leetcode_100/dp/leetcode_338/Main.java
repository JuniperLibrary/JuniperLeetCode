package com.uin.leetcode_100.dp.leetcode_338;

public class Main {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i - (i & -i)]+1;
        }
        return dp;
    }
}
