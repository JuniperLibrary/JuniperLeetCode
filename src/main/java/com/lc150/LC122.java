package com.lc150;

public class LC122 {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0) {
      return 0;
    }
    // 表示在第i天持有或不持有股票时的最大利润
    // 0持有现金 1持有股票
    int[][] dp = new int[n][2];
    // 第一天结束时持有现金
    dp[0][0] = 0;
    // 第一天结束时持有股票的，意味着买入，花费为当天股票价格，因为持有现金为负
    dp[0][1] = -prices[0];

    for (int i = 1; i < n; i++) {
      /*
      * 对于dp[i][0]（第i天结束时持有现金）：
            可以选择前一天结束时就持有现金，此时利润保持不变：dp[i - 1][0]
            或者前一天持有股票并在当天卖出，利润为前一天持有股票的利润加上当天卖出股票的收益：dp[i - 1][1] + prices[i]
            取两者中的较大值作为当前状态的值：dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
      * */
      // dp[i][0] 表示在第i天结束时持有现金的最大累计利润
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      /*
       * 对于dp[i][1]（第i天结束时持有股票）：
              可以选择前一天结束时就持有股票，此时利润保持不变：dp[i - 1][1]
              或者前一天持有现金并在当天买入，利润为前一天持有现金的利润减去当天买入股票的花费：dp[i - 1][0] - prices[i]
              取两者中的较大值作为当前状态的值：dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
       */
      // dp[i][1] 表示在第i天时持有股票的最大累计利润
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[n - 1][0];
  }
}
