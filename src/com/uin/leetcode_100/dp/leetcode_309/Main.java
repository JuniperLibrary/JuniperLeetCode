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
        int[] rest = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < n; i++) {
            //上一次，前一天休息减去这一次需要买入的
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            rest[i] = Math.max(sell[i - 1], Math.max(buy[i - 1], rest[i - 1]));
        }
        return sell[n - 1];
    }

    public int helper(int[] prices) {
        int n = prices.length;
        if (prices == null || n == 0) return 0;

        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] rest = new int[n];

        buy[0] = Integer.MIN_VALUE;
        sell[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
            rest[i] = Math.max(rest[i - 1], sell[i - 1]);
        }
        return Math.max(rest[n - 1], sell[n - 1]);
    }

    public int helperConst(int[] prices) {

        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int rest = 0;

        for (int price : prices) {
            int pre_sell = sell;
            sell = buy + price;
            buy = Math.max(buy, rest - price);
            rest = Math.max(rest, pre_sell);
        }
        return Math.max(rest, sell);
    }
}
