package com.uin.leetcode_100.dp.leetcode_309;

public class Main {
    /**
     * 买卖股票 3个状态 买 卖 休息
     *
     * @author wanglufei
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || n == 0) return 0;

        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        cooldown[0] = 0;

        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            cooldown[i] = Math.max(sell[i - 1], Math.max(buy[i - 1], cooldown[i - 1]));
        }
        return sell[n - 1];
    }
}
