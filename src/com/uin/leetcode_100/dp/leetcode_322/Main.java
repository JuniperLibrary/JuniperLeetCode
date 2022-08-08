package com.uin.leetcode_100.dp.leetcode_322;

import java.util.Arrays;

public class Main {
    /**
     * @param coins  表示不同面额的硬币
     * @param amount 表示总金额
     * @return int   计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * @author wanglufei
     * @date 2022/8/8 8:45 AM
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//可能amount为0元
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;//corner case

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                int leftAmount = currentAmount - coin;
                //剩下的金额  //剪支
                if (leftAmount < 0 || dp[leftAmount] == Integer.MAX_VALUE) continue;

                dp[currentAmount] = Math.min(dp[currentAmount], dp[leftAmount] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
