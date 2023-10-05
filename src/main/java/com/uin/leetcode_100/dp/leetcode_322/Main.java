package main.java.com.uin.leetcode_100.dp.leetcode_322;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。
 * 如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
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

    public static int coinMin(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        coinMin(coins, amount);
    }
}
