package com.uin.leetcode_100.dp.leetcode_300;

public class Main {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    len = Math.max(len, dp[j] + 1);
                }
            }
            dp[i] = len;
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }
        return maxLength;
    }
}
