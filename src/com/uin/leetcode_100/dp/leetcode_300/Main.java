package com.uin.leetcode_100.dp.leetcode_300;

import java.util.Arrays;

public class Main {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];

        int len = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}
